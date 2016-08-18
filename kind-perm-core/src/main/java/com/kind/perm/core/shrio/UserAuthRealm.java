package com.kind.perm.core.shrio;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kind.common.exception.CaptchaException;
import com.kind.common.mapper.JSONMapper;
import com.kind.common.uitls.StringUtils;
import com.kind.perm.core.contants.SessionConstants;
import com.kind.perm.core.domain.PermissionDO;
import com.kind.perm.core.domain.RoleDO;
import com.kind.perm.core.domain.UserDO;
import com.kind.perm.core.domain.UserRoleDO;
import com.kind.perm.core.dto.ExtendCaptchaToken;
import com.kind.perm.core.service.PermissionService;
import com.kind.perm.core.service.RoleService;
import com.kind.perm.core.service.UserService;

/**
 * 
 * Function:shiro权限控制. <br/>
 * 
 * @date:2016年5月12日 下午2:42:42 <br/>
 * @author weiguo.liu
 * @version:
 * @since:JDK 1.7
 */
@Service("userAuthRealm")
public class UserAuthRealm extends AuthorizingRealm {
	private static final Logger logger = LoggerFactory.getLogger(UserAuthRealm.class);

	@Resource
	private UserService userService;

	@Resource
	private PermissionService permissionService;

	@Resource
	private RoleService roleService;

	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		ExtendCaptchaToken token = (ExtendCaptchaToken) authcToken;
		UserDO user = userService.getUser(token.getUsername());
		if (user != null) {
			// ShiroUser shiroUser = new ShiroUser(user.getId(),
			// user.getUsername(), user.getUsername());
			this.initSession(user);
			SimpleAuthenticationInfo authInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(),
					user.getUsername());
			return authInfo;
		} else {
			return null;
		}
	}

	/**
	 * 设置用户session
	 */
	private void initSession(UserDO user) {
		logger.info("sessionTimeOut:" + SessionConstants.sessionTimeOut);
		Session session = SecurityUtils.getSubject().getSession();
		session.setTimeout(SessionConstants.sessionTimeOut);
		session.setAttribute(SessionConstants.SESSION_USER_KEY, user);
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		String username = (String) principals.getPrimaryPrincipal();
		UserDO userDO = userService.getUser(username);
		Long userId = userDO.getId();
		logger.debug("userDO:" + JSONMapper.getInstance().toJson(userDO));
		logger.debug("principals:" + JSONMapper.getInstance().toJson(SecurityUtils.getSubject().getPrincipals()));
		/**
		 * 把principals放session中 key=userId value=principals
		 */
		SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(userDO.getId()),
				SecurityUtils.getSubject().getPrincipals());
		SimpleAuthorizationInfo info = this.authUser(userId);

		/**
		 * 记录登录次数、时间
		 */
		userService.saveLoginTime(userDO);
		return info;
	}

	/**
	 * 为用户授权.
	 * 
	 * @param userId
	 * @return
	 */
	private SimpleAuthorizationInfo authUser(Long userId) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		/**
		 * 赋予角色
		 */
		List<UserRoleDO> userRoles = userService.getUserRoles(userId);
		for (UserRoleDO userRole : userRoles) {
			RoleDO role = roleService.getRoleById(userRole.getRoleId());
			logger.info("role:" + JSONMapper.getInstance().toJson(role));
			info.addRole(role.getCode());
		}
		/**
		 * 赋予权限
		 */
		List<PermissionDO> permissions = permissionService.getPermissionsByUserId(userId);
		for (PermissionDO permission : permissions) {
			if (StringUtils.isNotEmpty(permission.getPermCode()))
				info.addStringPermission(permission.getPermCode());
		}
		logger.info("permission:" + JSONMapper.getInstance().toJson(info.getStringPermissions()));
		return info;
	}

	/**
	 * 验证码校验.
	 * 
	 * @param token
	 * @return boolean
	 */
	protected boolean checkVerifyCode(ExtendCaptchaToken token) {
		String captcha = (String) SecurityUtils.getSubject().getSession()
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		if (captcha != null && !captcha.equalsIgnoreCase(token.getCaptcha())) {
			throw new CaptchaException("验证码错误！");
		}
		return true;
	}

	/**
	 * 设定Password校验.
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		/**
		 * 自定义密码验证
		 */
		setCredentialsMatcher(new CustomizedCredentialsMatcher());

	}

	/**
	 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
	 */
	public static class ShiroUser implements Serializable {
		private static final long serialVersionUID = -1373760761780840081L;
		public Long id;
		public String username;
		public String name;

		public ShiroUser(Long id, String username, String name) {
			this.id = id;
			this.username = username;
			this.name = name;
		}

		public Long getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		/**
		 * 本函数输出将作为默认的<shiro:principal/>输出.
		 */
		@Override
		public String toString() {
			return username;
		}

		/**
		 * 重载hashCode.
		 */
		@Override
		public int hashCode() {
			return Objects.hashCode(username);
		}

		/**
		 * 重载equals.
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			ShiroUser other = (ShiroUser) obj;
			if (username == null) {
				if (other.username != null) {
					return false;
				}
			} else if (!username.equals(other.username)) {
				return false;
			}
			return true;
		}
	}

	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	public void clearAllCache() {
		this.clearAllCachedAuthenticationInfo();
		this.clearAllCachedAuthorizationInfo();
	}

}
