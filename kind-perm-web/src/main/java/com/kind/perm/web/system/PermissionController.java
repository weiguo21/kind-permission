package com.kind.perm.web.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kind.common.mapper.JSONMapper;
import com.kind.common.uitls.NumberUtils;
import com.kind.perm.core.domain.PermissionDO;
import com.kind.perm.core.service.PermissionService;
import com.kind.perm.core.shrio.SessionUtils;
import com.kind.perm.web.common.controller.BaseController;

/**
 * 
 * Function:权限控制器. <br/>
 * 
 * @date:2016年5月12日 上午11:18:13 <br/>
 * @author weiguo21
 * @version:
 * @since:JDK 1.7
 */
@Controller
@RequestMapping("system/permission")
public class PermissionController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(PermissionController.class);

	@Autowired
	private PermissionService permissionService;

	/**
	 * 默认页面.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list() {
		return "system/permission_list";
	}

	/**
	 * 菜单页面.
	 */
	@RequestMapping(value = "menu", method = RequestMethod.GET)
	public String toMenuList() {
		return "system/menu_list";
	}

	/**
	 * 全部菜单数据.
	 * 
	 * @return
	 */
	@RequiresPermissions("sys:perm:menu:view")
	@RequestMapping(value = "menu/json", method = RequestMethod.GET)
	@ResponseBody
	public List<PermissionDO> getAllMenus() {
		List<PermissionDO> permissionList = permissionService.getAllMenus();
		return permissionList;
	}

	/**
	 * 全部权限数据.
	 * 
	 * @return
	 */
	@RequiresPermissions("sys:perm:view")
	@RequestMapping(value = "json", method = RequestMethod.GET)
	@ResponseBody
	public List<PermissionDO> getAllPermissions() {
		List<PermissionDO> permissionList = permissionService.getAllPermissions();
		return permissionList;
	}

	/**
	 * 获取菜单下的操作
	 */
	@RequiresPermissions("sys:perm:view")
	@RequestMapping("operation/json")
	@ResponseBody
	public Map<String, Object> getMenuOperations(Long parentId) {
		logger.debug("parentId:" + parentId);
		Map<String, Object> map = new HashMap<String, Object>();
		if (!NumberUtils.isEmptyLong(parentId)) {
			List<PermissionDO> menuOperList = permissionService.getMenuOperations(parentId);
			map.put("rows", menuOperList);
			map.put("total", menuOperList.size());
		}
		return map;
	}

	/**
	 * 当前登录用户的权限集合.
	 */
	@RequestMapping("i/json")
	@ResponseBody
	public List<PermissionDO> geCurrentPermissions() {
		List<PermissionDO> permissionList = permissionService.getPermissionsByUserId(SessionUtils.getCurrentUserId());
		return permissionList;
	}

	/**
	 * 某用户的权限集合.
	 */
	@RequiresPermissions("sys:perm:view")
	@RequestMapping("{userId}/json")
	@ResponseBody
	public List<PermissionDO> getUserPermissions(@PathVariable("userId") Long userId) {
		if (NumberUtils.isEmptyLong(userId)) {
			return null;
		}
		List<PermissionDO> permissionList = permissionService.getPermissionsByUserId(userId);
		return permissionList;
	}

	/**
	 * 添加权限跳转
	 */
	@RequestMapping(value = "toSave", method = RequestMethod.GET)
	public String toSave(Model model) {
		model.addAttribute("permission", new PermissionDO());
		model.addAttribute("action", "save");
		return "system/permission_form";
	}

	/**
	 * 添加菜单跳转
	 */
	@RequestMapping(value = "menu/save", method = RequestMethod.GET)
	public String toSaveMenu(Model model) {
		model.addAttribute("permission", new PermissionDO());
		model.addAttribute("action", "save");
		return "system/menu_form";
	}

	/**
	 * 添加权限/菜单
	 */
	@RequiresPermissions("sys:perm:save")
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public String save(@Valid PermissionDO permission, Model model) {
		logger.debug("permission:" + JSONMapper.getInstance().toJson(permission));
		permissionService.save(permission);
		return "success";
	}

	/**
	 * 修改权限跳转
	 */
	@RequestMapping(value = "change/{id}", method = RequestMethod.GET)
	public String toChangePerm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("permission", permissionService.getById(id));
		model.addAttribute("action", "change");
		return "system/permission_form";
	}

	/**
	 * 修改菜单跳转
	 */
	@RequestMapping(value = "menu/change/{id}", method = RequestMethod.GET)
	public String toChangeMenu(@PathVariable("id") Long id, Model model) {
		model.addAttribute("permission", permissionService.getById(id));
		model.addAttribute("action", "change");
		return "system/menu_form";
	}

	/**
	 * 修改权限/菜单
	 */
	@RequiresPermissions("sys:perm:change")
	@RequestMapping(value = "change", method = RequestMethod.POST)
	@ResponseBody
	public String change(@Valid @ModelAttribute("permission") PermissionDO permission, Model model) {
		logger.info("change permission:" + JSONMapper.getInstance().toJson(permission));
		permissionService.change(permission);
		return "success";
	}

	/**
	 * 删除权限
	 */
	@RequiresPermissions("sys:perm:remove")
	@RequestMapping(value = "remove/{id}")
	@ResponseBody
	public String remove(@PathVariable("id") Long id) {
		permissionService.remove(id);
		return "success";
	}

	@ModelAttribute
	public void getPermission(@RequestParam(value = "id", defaultValue = "-1") Long id, Model model) {
		if (id != -1) {
			model.addAttribute("permission", permissionService.getById(id));
		}
	}
}
