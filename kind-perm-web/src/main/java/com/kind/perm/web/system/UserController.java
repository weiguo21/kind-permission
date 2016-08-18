package com.kind.perm.web.system;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kind.common.dto.KafaDataGrid;
import com.kind.common.dto.KindResult;
import com.kind.common.persistence.PageView;
import com.kind.common.uitls.NumberUtils;
import com.kind.perm.core.domain.UserDO;
import com.kind.perm.core.domain.UserRoleDO;
import com.kind.perm.core.dto.request.PasswordRequest;
import com.kind.perm.core.dto.request.UserQueryRequest;
import com.kind.perm.core.form.UserInputForm;
import com.kind.perm.core.service.UserService;
import com.kind.perm.core.shrio.SessionUtils;
import com.kind.perm.web.common.controller.BaseController;

/**
 * 
 * Function:用户控制器. <br/>
 * 
 * @date:2016年5月12日 上午11:17:52 <br/>
 * @author weiguo21
 * @version:
 * @since:JDK 1.7
 */
@Controller
@RequestMapping("system/user")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	/**
	 * 默认页面.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String toUserList(Model model) {
		return "system/user_list";
	}

	/**
	 * 获取用户JOSN数据.
	 */
	@RequiresPermissions("sys:user:view")
	@RequestMapping(value = "json", method = RequestMethod.GET)
	@ResponseBody
	public KafaDataGrid pageUser(UserQueryRequest userRequest, HttpServletRequest request) {
		PageView<UserDO> page = userService.pageUser(userRequest);
		return super.buildDataGrid(page);
	}

	/**
	 * 添加用户跳转.
	 * 
	 * @param model
	 */
	@RequiresPermissions("sys:user:save")
	@RequestMapping(value = "toSave", method = RequestMethod.GET)
	public String toSaveUser(Model model) {
		model.addAttribute("user", new UserInputForm(new UserDO()));
		model.addAttribute("action", "save");
		return "system/user_form";
	}

	/**
	 * 添加用户.
	 * 
	 * @param user
	 * @param model
	 */
	@RequiresPermissions("sys:user:save")
	@RequestMapping(value = "save", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String saveUser(@Valid UserDO userDO, Model model) {
		logger.debug("userDO:" + userDO);
		if (userService.getUser(userDO.getUsername()) == null) {
			userService.saveUser(userDO);
			return "success";
		}
		String errorMsg = "用户名已经存在";
		return errorMsg;
	}

	@SuppressWarnings("unused")
	private Boolean checkUserDO(UserDO userDO) {
		if (userDO == null) {
			return false;
		}
		return true;
	}

	/**
	 * 修改用户跳转.
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("sys:user:change")
	@RequestMapping(value = "change/{id}", method = RequestMethod.GET)
	public String toChangeUser(@PathVariable("id") Long id, Model model) {
		UserDO userDO = userService.getById(id);
		model.addAttribute("user", new UserInputForm(userDO));
		model.addAttribute("action", "change");
		return "system/user_form";
	}

	/**
	 * 修改用户.
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@RequiresPermissions("sys:user:change")
	@RequestMapping(value = "change", method = RequestMethod.POST)
	@ResponseBody
	public String changeUser(@Valid @ModelAttribute @RequestBody UserDO userDO, Model model) {
		userService.changeUser(userDO);
		return "success";
	}

	/**
	 * 删除用户.
	 * 
	 * @param id
	 * @return
	 */
	@RequiresPermissions("sys:user:remove")
	@RequestMapping(value = "remove/{id}")
	@ResponseBody
	public String removeUser(@PathVariable("id") Long id) {
		if (!NumberUtils.isEmptyLong(id)) {
			userService.remove(id);
		}
		return "success";
	}

	/**
	 * 弹窗页-用户拥有的角色
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequiresPermissions("sys:user:roleView")
	@RequestMapping(value = "{userId}/userRole")
	public String toUserRoleList(@PathVariable("userId") Long id, Model model) {
		model.addAttribute("userId", id);
		return "system/user_role_list";
	}

	/**
	 * 获取用户拥有的角色ID集合
	 * 
	 * @param id
	 * @return
	 */
	@RequiresPermissions("sys:user:roleView")
	@RequestMapping(value = "{id}/role")
	@ResponseBody
	public List<Long> getRoleIdList(@PathVariable("id") Long userId) {
		if (NumberUtils.isEmptyLong(userId)) {
			return null;
		}
		return getUserRoleIds(userId);
	}

	/**
	 * 修改用户拥有的角色
	 * 
	 * @param id
	 * @param newRoleList
	 * @return
	 */
	@RequiresPermissions("sys:user:roleChange")
	@RequestMapping(value = "{id}/changeRole")
	@ResponseBody
	public String changeUserRole(@PathVariable("id") Long userId, @RequestBody List<Long> targetRoles) {
		userService.changeUserRole(userId, getRoleIdList(userId), targetRoles);
		return "success";
	}

	/**
	 * 包装数据.
	 * 
	 * @param userId
	 * @return
	 */
	private List<Long> getUserRoleIds(Long userId) {
		List<UserRoleDO> roles = userService.getUserRoles(userId);
		List<Long> roleIds = new ArrayList<>();
		for (UserRoleDO userRole : roles) {
			roleIds.add(userRole.getRoleId());
		}
		return roleIds;
	}

	/**
	 * 修改密码跳转
	 */
	@RequestMapping(value = "toChangePasswod")
	public String toChangePassword(Model model, HttpSession session) {
		model.addAttribute("user", SessionUtils.getCurrentUser());
		return "system/password_change";
	}

	/**
	 * 修改密码
	 */
	@RequestMapping(value = "changePassword")
	@ResponseBody
	public KindResult changePassword(String oldPassword,
			@Valid @ModelAttribute @RequestBody PasswordRequest passwordRequest, HttpSession session) {
		UserDO userDO = SessionUtils.getCurrentUser();
		if (userDO != null && userDO.getId().equals(passwordRequest.getUserId())) {
			return userService.changePassword(passwordRequest);
		}
		return KindResult.build(300, "参数有误");

	}

	/**
	 * 校验用户名是否存在.
	 * 
	 * @param loginName
	 * @return
	 */
	@RequestMapping(value = "checkUsername")
	@ResponseBody
	public String checkUsername(String username) {
		logger.debug("username:" + username);
		if (userService.getUser(username) == null) {
			return "true";
		}
		return "false";
	}

	/**
	 * ajax请求校验原密码是否正确.
	 * 
	 * @param oldPassword
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "checkPassword")
	@ResponseBody
	public String checkPassword(@RequestParam(value = "originPassword", defaultValue = "") String originPassword,
			HttpServletRequest request) {
		logger.debug("originPassword:" + originPassword);
		UserDO user = SessionUtils.getCurrentUser();
		if (userService.checkPassword(user, originPassword)) {
			return "true";
		}
		return "false";
	}

	/**
	 * 所有RequestMapping方法调用前的Model准备方法, 实现Struts2
	 * Preparable二次部分绑定的效果,先根据form的id从数据库查出Task对象,再把Form提交的内容绑定到该对象上。
	 * 因为仅update()方法的form中有id属性，因此仅在update时实际执行.
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value = "id", defaultValue = "-1") Integer id, Model model) {
		/*
		 * if (id != -1) { model.addAttribute("user", userService.get(id)); }
		 */
	}

}
