package com.kind.perm.web.system;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kind.common.config.CustomizedPropertyConfigurer;

/**
 * Function:登录控制器. <br/>
 * 
 * @date:2016年5月12日 上午11:18:32 <br/>
 * @author weiguo.liu
 * @version:
 * @since:JDK 1.7
 */
@Controller
@RequestMapping(value = "{back.adminPath}")
public class LoginController {
	/**
	 * 后台跳转地址
	 */
	@Value("back.adminPath")
	private String adminPath;

	private String getAdminPath() {
		return (String) CustomizedPropertyConfigurer.getContextProperty(adminPath);
	}

	/**
	 * 默认页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Model model) {
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated() || subject.isRemembered()) {
			return "redirect:" + getAdminPath();
		}
		return this.toLogin(model);
	}

	/**
	 * 加载登陆页面
	 * 
	 * @param model
	 * @return
	 */
	public String toLogin(Model model) {
		return "system/login";
	}

	/**
	 * 登录失败
	 * 
	 * @param userName
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String doLogin(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String username,
			@RequestParam(FormAuthenticationFilter.DEFAULT_PASSWORD_PARAM) String password, Model model) {
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			return this.toLogin(model);
		}
		model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, username);
		return this.toLogin(model);
	}

	/**
	 * 登出
	 * 
	 * @param userName
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "logout")
	public String logout(Model model) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return this.toLogin(model);
	}

}
