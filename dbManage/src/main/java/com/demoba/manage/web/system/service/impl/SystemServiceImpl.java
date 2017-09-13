package com.demoba.manage.web.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demoba.manage.web.dao.MenuMapper;
import com.demoba.manage.web.dao.MenuPermissionMapper;
import com.demoba.manage.web.dao.RoleMapper;
import com.demoba.manage.web.dao.RoleMenuMapper;
import com.demoba.manage.web.dao.RolePermissionMapper;
import com.demoba.manage.web.dao.SystemUserMapper;
import com.demoba.manage.web.dao.UserRoleMapper;
import com.demoba.manage.web.entity.Menu;
import com.demoba.manage.web.entity.MenuPermission;
import com.demoba.manage.web.entity.Role;
import com.demoba.manage.web.entity.RoleMenu;
import com.demoba.manage.web.entity.RolePermission;
import com.demoba.manage.web.entity.SystemUser;
import com.demoba.manage.web.entity.UserRole;
import com.demoba.manage.web.system.dto.AdminListDto;
import com.demoba.manage.web.system.dto.GroupListDto;
import com.demoba.manage.web.system.dto.MenuDto;
import com.demoba.manage.web.system.dto.MenuTreeDto;
import com.demoba.manage.web.system.model.AddAdminModel;
import com.demoba.manage.web.system.model.AddGroupModel;
import com.demoba.manage.web.system.model.AdminListModel;
import com.demoba.manage.web.system.model.GroupListModel;
import com.demoba.manage.web.system.model.ModifyAdminModel;
import com.demoba.manage.web.system.model.ModifyGroupModel;
import com.demoba.manage.web.system.service.SystemService;
import com.owl.common.content.Status;
import com.owl.common.util.Help;
import com.owl.common.util.MUtil;
import com.owl.common.util.Paginator;
import com.owl.common.util.Result;
@Service
@Transactional
public class SystemServiceImpl implements SystemService{
	private static final Logger log= LoggerFactory.getLogger(SystemServiceImpl.class);
    @Autowired
    private SystemUserMapper systemUserMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Autowired
    private MenuPermissionMapper menuPermissionMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
	@Override
	public Result login(HttpServletRequest request,String userName, String userPwd) {
		// TODO Auto-generated method stub
		Result result = new Result();
		 log.debug("开始验证参数");
		if(MUtil.isEmpty(userName)){
			result.setStatus(Status.account_error_status);
			result.setInfo(Status.account_error_info);
			return result;
		}
		
		if(MUtil.isEmpty(userPwd)){
			result.setStatus(Status.pwd_error_status);
			result.setInfo(Status.pwd_error_info);
			return result;
		}
		
		 SystemUser login = systemUserMapper.login(userName, MUtil.md5(userPwd));
	     if (Help.isNotNull(login)) {
	             setSessionUser(request, login);
	             result.setStatus(Status.success_status);
	             result.setInfo(Status.success_info);
	             // Menu
	             request.getSession().setAttribute("sys_menu", getMenus(login.getnUserId()));
	             // End
	             return result;
	     }
	     result.setStatus(Status.login_error_status);
	     result.setInfo(Status.login_error_info);
	     return result;
	}

	@Override
	public Result getUserMenus(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Result result = new Result();
		SystemUser loginUser = getSessionUser(request);
		List<MenuDto> menus = null;
		if(Help.isNotNull(loginUser)){
			Long id = loginUser.getnUserId();
			 menus = getMenus(id);
		}
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("menus", menus);
		result.setData(data);
		return result;
	}
	
	private List<MenuDto> getMenus(Long userId){
		Map<Object,Object> map = new HashMap<Object,Object>();
		List<Menu> userMenus =null;
        if(Help.isNotNull(userId)){
        	userMenus = menuMapper.findUserMenusByUserId(userId);
        }	
        if(Help.isNotNull(userMenus)){
    		for(Menu menu:userMenus){
    			Long parentMenuId = menu.getnParentMenuId();
    			List<Menu> menus = (List<Menu>) map.get(parentMenuId);
    			if(Help.isNull(menus)){
    				menus=new ArrayList<Menu>();
    			}
    			menus.add(menu);
    			map.put(parentMenuId, menus);
    		}
    	}
       return  convertMenus(map, 0l);
	}
	private List<MenuDto> convertMenus(Map<Object,Object> menuMap,Long parentMenuId){
		List<MenuDto> menuDtos=new ArrayList<MenuDto>();
			if(Help.isNotNull(menuMap)){
				List<Menu> menus = (List<Menu>) menuMap.get(parentMenuId);
				if(Help.isNotNull(menus)){
					for(Menu menu:menus){
						MenuDto menuDto = new MenuDto();
						menuDto.setMenuIcon(menu.getcMenuIcon());
						menuDto.setMenuName(menu.getcMenuName());
						menuDto.setMenuUrl(menu.getcMenuUrl());
						menuDto.setSubMenus(convertMenus(menuMap, menu.getnMenuId()));
						menuDtos.add(menuDto);
					}
				}
		}
		return menuDtos;
	}

	@Override
	public Result groupList(GroupListModel groupListModel) {
		Result result = new Result();
		Map<String, Object> param= new HashMap<String,Object>();
		int pageCount =1;
		List<GroupListDto> groupListDtos = new ArrayList<GroupListDto>();
		Map<String, Object> data = new HashMap<String, Object>();
		int count = 0;
		if(Help.isNotNull(groupListModel)){
		roleMapper.countAdminGroupByParam();
		count = roleMapper.countAdminGroupByParam();
		/**** 分页判断begin *****/
		Paginator paginator = new Paginator(0, groupListModel.getPageSize());
		paginator.gotoPage(groupListModel.getPage());
		pageCount = paginator.calcPageCount(count); // 总页数
		
		/**** 分页判断end *****/
		param.put("startRow", paginator.getStartRow());
		param.put("pageSize", paginator.getPageSize());
		
		data.put("page", groupListModel.getPage());
		data.put("pageSize", groupListModel.getPageSize());
		}
		List<Role> roles = roleMapper.findAdminGroupByParam(param);
		
		if(Help.isNotNull(roles)){
			for(Role role:roles){
				GroupListDto groupListDto = new GroupListDto();
				groupListDto.setGroupDesc(role.getcRoleDesc());
				groupListDto.setGroupName(role.getcRoleName());
				groupListDto.setGroupId(role.getnRoleId());
				groupListDto.setGroupCode(role.getnRoleCode());
				groupListDtos.add(groupListDto);
			}
		}
		
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		
		data.put("pageCount", pageCount);
		data.put("dataList", groupListDtos);
		data.put("count", count);
		result.setData(data);
		return result;
	}

	@Override
	public Result menuTree(Long userId, Long roleCode) {
		Result result = new Result();
		List<Menu> userMenus = null;
		if(Help.isNotNull(userId)){
			userMenus = menuMapper.findUserMenusByUserId(userId);
		}else{
			userMenus = menuMapper.findAll();
		}
		List<MenuTreeDto> menuTreeDtos = new ArrayList<MenuTreeDto>();
		List<Menu> roleMenus =null;
		if(Help.isNotNull(roleCode)){
			roleMenus = menuMapper.findUserMenusByRoleCode(roleCode);
		}
		if(Help.isNotNull(userMenus)){
			for(Menu userMenu:userMenus){
				MenuTreeDto menuTreeDto = new MenuTreeDto();
				menuTreeDto.setId(userMenu.getnMenuId());
				menuTreeDto.setpId(userMenu.getnParentMenuId());
				menuTreeDto.setName(userMenu.getcMenuName());
				if(Help.isNotNull(roleMenus)&&roleMenus.contains(userMenu)){
					menuTreeDto.setChecked(true);
				}
				menuTreeDto.setOpen(true);
				menuTreeDtos.add(menuTreeDto);
			}
		}
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("dataList", menuTreeDtos);
		result.setData(data);
		return result;
	}

	@Override
	public Result addGroup(HttpServletRequest request,AddGroupModel addGroupModel) {
		// TODO Auto-generated method stub
		Result result = new Result();
		log.debug("参数=="+addGroupModel);
		if(Help.isNull(addGroupModel)){
			log.debug("参数错误！！");
			result.setStatus(Status.param_error_status);
			result.setInfo(Status.param_error_info);
			return result;
		}
		String groupName = addGroupModel.getGroupName();
		if(Help.isNull(groupName)){
			log.debug("groupName为空，groupName="+groupName);
			result.setStatus(Status.group_name_empty_status);
			result.setInfo(Status.group_name_empty_info);
			return result;
		}
		String groupDesc = addGroupModel.getGroupDesc();
		if(Help.isNull(groupDesc)){
			log.debug("groupDesc为空，groupDesc="+groupDesc);
			result.setStatus(Status.group_desc_empty_status);
			result.setInfo(Status.group_desc_empty_info);
			return result;
		}
		String menuIdsStr = addGroupModel.getMenuIdsStr();
		List<String> menuIds = MUtil.convertStringToList(menuIdsStr);
		if(Help.isNull(menuIds)){
			log.debug("menuIds为空，menuIds="+menuIds);
			result.setStatus(Status.group_permission_empty_status);
			result.setInfo(Status.group_permission_empty_info);
			return result;
		}
		Role role = roleMapper.findByName(groupName);
		if(Help.isNotNull(role)){
			log.debug("groupName已经存在，groupName="+groupName);
			result.setStatus(Status.group_name_exist_status);
			result.setInfo(Status.group_name_exist_info);
			return result;
		}
		log.debug("验证参数成功，插入群组信息");
		role=new Role();
		role.setcRoleDesc(groupDesc);
		role.setcRoleName(groupName);
		Integer maxRoleCode = roleMapper.maxRoleCode();
		if(Help.isNull(maxRoleCode)){
			maxRoleCode=100;
		}else{
			maxRoleCode=maxRoleCode+1;
		}
		role.setnRoleCode(Long.parseLong(maxRoleCode.toString()));
		SystemUser sessionUser = getSessionUser(request);
		Long userId = sessionUser.getnUserId();
		Date now = new Date();
		role.setnCreateBy(userId);
		role.setnUpdateBy(userId);
		role.settCreateTime(now);
		role.settUpdateTime(now);
		role.setnSystemRole(0);
		roleMapper.insertSelective(role);
		Long roleCode = role.getnRoleCode();
		log.debug("插入群组信息成功");
		log.debug("开始添加权限信息。。。");
		addGroupPermissoin(menuIds, userId, roleCode);
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		return result;
	}
    private SystemUser getSessionUser(HttpServletRequest request){
    	return (SystemUser) request.getSession().getAttribute("user");
    }
    private void setSessionUser(HttpServletRequest request,SystemUser user){
    	request.getSession().setAttribute("user",user);
    }
  //添加权限
  	private void addGroupPermissoin(List<String> menuIds,Long userId,Long roleCode){
  		for(String menuId:menuIds){
  			RoleMenu roleMenu = new RoleMenu();
  			roleMenu.setnCreateBy(userId);
  			roleMenu.setnRoleCode(roleCode);
  			roleMenu.setnMenuId(Long.parseLong(menuId));
  			roleMenu.setnStatus(1);
  			roleMenu.setnUpdateBy(userId);
  			roleMenu.settCreateTime(new Date());
  			roleMenu.settUpdateTime(new Date());
  			roleMenuMapper.insertSelective(roleMenu);
  			
  			List<MenuPermission> menuPermissions = menuPermissionMapper.findByMenuId(Long.parseLong(menuId));
  			if(Help.isNotNull(menuPermissions)){
  				for(MenuPermission menuPermission:menuPermissions){
  					Long permissionId = menuPermission.getnPermissionId();
  				    RolePermission rolerPermission = new RolePermission();
  				    rolerPermission.setnPermissionId(permissionId);
  				    rolerPermission.setnRoleCode(roleCode);
  					rolePermissionMapper.insertSelective(rolerPermission);
  				}
  			}
  		}
  	}

	@Override
	public Result roleDetail(Long groupId){
		Result result= new Result();
		Role role = roleMapper.selectByPrimaryKey(groupId);
		if(Help.isNull(role)){
			result.setStatus(Status.role_not_exist_status);
			result.setInfo(Status.role_not_exist_info);
			return result;
		}
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("roleDetail", role);
		result.setData(data);
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		return result;
	}

	@Override
	public Result modifyGroup(HttpServletRequest request,ModifyGroupModel modifyGroupModel) {
		// TODO Auto-generated method stub
		log.debug("modifyGroupModel=="+modifyGroupModel);
		Result result = new Result();
		if(Help.isNull(modifyGroupModel)){
			log.debug("参数错误！！");
			result.setStatus(Status.param_error_status);
			result.setInfo(Status.param_error_info);
			return result;
		}
		Long groupId = modifyGroupModel.getGroupId();
		if(Help.isNull(groupId)){
			log.debug("groupId=="+groupId);
			result.setStatus(Status.group_no_exist_status);
			result.setInfo(Status.group_no_exist_info);
			return result;
		}
		Role role = roleMapper.selectByPrimaryKey(groupId);
		if(Help.isNull(role)){
			result.setStatus(Status.group_no_exist_status);
			result.setInfo(Status.group_no_exist_info);
			return result;
		}
		Integer systemRole = role.getnSystemRole();
		if(systemRole==1){
			result.setStatus(Status.system_role_opera_error_status);
			result.setInfo(Status.system_role_opera_error_info);
			return result;
		}
		String groupName = modifyGroupModel.getGroupName();
		if(Help.isNull(groupName)){
			log.debug("groupName为空，groupName="+groupName);
			result.setStatus(Status.group_name_empty_status);
			result.setInfo(Status.group_name_empty_info);
			return result;
		}
		String groupDesc = modifyGroupModel.getGroupDesc();
		if(Help.isNull(groupDesc)){
			log.debug("groupDesc为空，groupDesc="+groupDesc);
			result.setStatus(Status.group_desc_empty_status);
			result.setInfo(Status.group_desc_empty_info);
			return result;
		}
		String menuIdsStr = modifyGroupModel.getMenuIdsStr();
		List<String> menuIds = MUtil.convertStringToList(menuIdsStr);
		if(Help.isNull(menuIds)){
			log.debug("menuIds为空，menuIds="+menuIds);
			result.setStatus(Status.group_permission_empty_status);
			result.setInfo(Status.group_permission_empty_info);
			return result;
		}
		Role r = roleMapper.findByName(groupName);
		if(Help.isNotNull(r)&&!r.getnRoleId().equals(role.getnRoleId())){
			log.debug("groupName已经存在，groupName="+groupName);
			result.setStatus(Status.group_name_exist_status);
			result.setInfo(Status.group_name_exist_info);
			return result;
		}
		role.setcRoleName(groupName);
		role.setcRoleDesc(groupDesc);
		roleMapper.updateByPrimaryKeySelective(role);
		Long roleCode = role.getnRoleCode();
		log.debug("删除roleCode的关联关系=="+roleCode);
		roleMenuMapper.deleteByRoleCode(roleCode);
		rolePermissionMapper.deleteByRoleCode(roleCode);
		SystemUser sessionUser = getSessionUser(request);
		addGroupPermissoin(menuIds, sessionUser.getnUserId(), roleCode);
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		return result;
	}

	@Override
	public Result delGroup(Long groupId) {

		// TODO Auto-generated method stub
		Result result = new Result();
		if(Help.isNull(groupId)){
			log.debug("groupId=="+groupId);
			result.setStatus(Status.group_no_exist_status);
			result.setInfo(Status.group_no_exist_info);
			return result;
		}
		Role role = roleMapper.selectByPrimaryKey(groupId);
		if(Help.isNull(role)){
			result.setStatus(Status.group_no_exist_status);
			result.setInfo(Status.group_no_exist_info);
			return result;
		}
		Integer systemRole = role.getnSystemRole();
		if(systemRole==1){
			result.setStatus(Status.system_role_opera_error_status);
			result.setInfo(Status.system_role_opera_error_info);
			return result;
		}
		Long roleCode = role.getnRoleCode();
		roleMapper.deleteByPrimaryKey(groupId);
		roleMenuMapper.deleteByRoleCode(roleCode );
		rolePermissionMapper.deleteByRoleCode(roleCode);
		userRoleMapper.deleteByRoleCode(roleCode);
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		return result;
	
	}

	@Override
	public Result adminList(AdminListModel adminListModel) {
		Result result = new Result();
		Map<String, Object> param = new HashMap<String,Object>();
		param.put("keyword", adminListModel.getKeywords());
		int count = systemUserMapper.countByParam(param);
		/**** 分页判断begin *****/
		Paginator paginator = new Paginator(0, adminListModel.getPageSize());
		paginator.gotoPage(adminListModel.getPage());
		int pageCount = paginator.calcPageCount(count); // 总页数
		/**** 分页判断end *****/
		param.put("startRow", paginator.getStartRow());
		param.put("pageSize", paginator.getPageSize());
		
		List<SystemUser> users = systemUserMapper.findByParam(param );
		List<AdminListDto> adminListDtos=new ArrayList<AdminListDto>();
		if(Help.isNotNull(users)){
			for(SystemUser user:users){
				AdminListDto adminListDto=new AdminListDto();
				adminListDto.setUserAccount(user.getcUserName());
				adminListDto.setUserId(user.getnUserId());
				adminListDto.setUserName(user.getcRealName());
				List<Role> roles = roleMapper.findByUserId(user.getnUserId());
				List<GroupListDto> groupListDtos = new ArrayList<GroupListDto>();
				if(Help.isNotNull(roles)){
					for(Role role:roles){
						GroupListDto groupListDto = new GroupListDto();
						groupListDto.setGroupCode(role.getnRoleCode());
						groupListDto.setGroupDesc(role.getcRoleDesc());
						groupListDto.setGroupName(role.getcRoleName());
						groupListDto.setGroupId(role.getnRoleId());
						groupListDtos.add(groupListDto);
					}
				}
				adminListDto.setGroupList(groupListDtos);
				adminListDtos.add(adminListDto);
			}
		}
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("page", adminListModel.getPage());
		data.put("pageSize", adminListModel.getPageSize());
		data.put("pageCount", pageCount);
		data.put("dataList", adminListDtos);
		result.setData(data);
		return result;
	}

	@Override
	public Result addAdmin(AddAdminModel addAdminModel) {
		// TODO Auto-generated method stub
		log.debug("addAdminModel=="+addAdminModel);
		Result result = new Result();
		if(Help.isNull(addAdminModel)){
			log.debug("参数错误！！");
			result.setStatus(Status.param_error_status);
			result.setInfo(Status.param_error_info);
			return result;
		}
		String userAccount = addAdminModel.getUserAccount();
		if(Help.isNull(userAccount)){
			log.debug("用户名为空！！userName="+userAccount);
			result.setStatus(Status.useraccount_empty_status);
			result.setInfo(Status.useraccount_empty_info);
			return result;
		}
		String password = addAdminModel.getPassword();
		if(Help.isNull(password)){
			log.debug("密码为空！！password="+password);
			result.setStatus(Status.pwd_error_status);
			result.setInfo(Status.pwd_error_info);
			return result;
		}
		String confirmPassword = addAdminModel.getConfirmPassword();
		if(!password.equals(confirmPassword)){
			log.debug("两次输入密码不一致！");
			result.setStatus(Status.pwd_confirm_error_status);
			result.setInfo(Status.pwd_confirm_error_info);
			return result;
		}
		String roleCodes = addAdminModel.getRoleCodes();
		if(Help.isNull(roleCodes)){
			log.debug("roleCodes为空，roleCodes="+roleCodes);
			result.setStatus(Status.role_empty_error_status);
			result.setInfo(Status.role_empty_error_info);
			return result;
		}
		Map<String, Object> param = new HashMap<String,Object>();
		param.put("userName", userAccount);
		SystemUser account = systemUserMapper.findByUserName(userAccount );
		if(Help.isNotNull(account)){
			result.setStatus(Status.useraccount_exist_status);
			result.setInfo(Status.useraccount_exist_info);
			return result;
		}
		SystemUser user=new SystemUser();
		user.setcUserName(userAccount);
		user.setcUserPwd(MUtil.md5(password));
		systemUserMapper.insertSelective(user);
		Long userId = user.getnUserId();
		List<String> roles = MUtil.convertStringToList(roleCodes);
		for(String roleCode:roles){
			UserRole userRole = new UserRole();
			userRole.setnUserId(userId);
			userRole.setnRoleCode(Integer.parseInt(roleCode));
			userRoleMapper.insertSelective(userRole );
		}
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		return result;
	}

	@Override
	public Result adminInfo(Long userId) {
		Result result = new Result();
		if(Help.isNull(userId)){
			result.setStatus(Status.admin_no_exist_status);
			result.setInfo(Status.admin_no_exist_info);
			return result;
		}
		SystemUser userAccount = systemUserMapper.selectByPrimaryKey(userId);
		if(Help.isNull(userAccount)){
			result.setStatus(Status.admin_no_exist_status);
			result.setInfo(Status.admin_no_exist_info);
			return result;
		}
		AdminListDto adminListDto = new AdminListDto();
		List<Role> roles = roleMapper.findByUserId(userId);
		List<GroupListDto> groupListDtos = new ArrayList<GroupListDto>();
		if(Help.isNotNull(roles)){
			for(Role role:roles){
				GroupListDto groupListDto = new GroupListDto();
				groupListDto.setGroupCode(role.getnRoleCode());
				groupListDto.setGroupDesc(role.getcRoleDesc());
				groupListDto.setGroupName(role.getcRoleName());
				groupListDto.setGroupId(role.getnRoleId());
				groupListDtos.add(groupListDto);
			}
		}
		adminListDto.setGroupList(groupListDtos);
		adminListDto.setUserAccount(userAccount.getcUserName());
		adminListDto.setUserId(userId);
		adminListDto.setUserName(userAccount.getcRealName());
		
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("admin", adminListDto);
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		result.setData(data);
		return result;
	}

	@Override
	public Result modifyAdmin(ModifyAdminModel modifyAdminModel) {
		// TODO Auto-generated method stub
		log.debug("modifyAdminModel=="+modifyAdminModel);
		Result result = new Result();
		if(Help.isNull(modifyAdminModel)){
			log.debug("参数错误！！");
			result.setStatus(Status.param_error_status);
			result.setInfo(Status.param_error_info);
			return result;
		}
		Long userId = modifyAdminModel.getUserId();
		if(Help.isNull(userId)){
			result.setStatus(Status.admin_no_exist_status);
			result.setInfo(Status.admin_no_exist_info);
			return result;
		}
		SystemUser user = systemUserMapper.selectByPrimaryKey(userId);
		if(Help.isNull(user)){
			result.setStatus(Status.admin_no_exist_status);
			result.setInfo(Status.admin_no_exist_info);
			return result;
		}
		String password = modifyAdminModel.getPassword();
		if(Help.isNull(password)){
			log.debug("密码为空！！password="+password);
			result.setStatus(Status.pwd_error_status);
			result.setInfo(Status.pwd_error_info);
			return result;
		}
		String confirmPassword = modifyAdminModel.getConfirmPassword();
		if(!password.equals(confirmPassword)){
			log.debug("两次输入密码不一致！");
			result.setStatus(Status.pwd_confirm_error_status);
			result.setInfo(Status.pwd_confirm_error_info);
			return result;
		}
		String roleCodes = modifyAdminModel.getRoleCodes();
		if(Help.isNull(roleCodes)){
			log.debug("roleCodes为空，roleCodes="+roleCodes);
			result.setStatus(Status.role_empty_error_status);
			result.setInfo(Status.role_empty_error_info);
			return result;
		}
		String userAccount = modifyAdminModel.getUserAccount();
		if(Help.isNull(userAccount)){
			log.debug("用户名为空！！userAccount="+userAccount);
			result.setStatus(Status.useraccount_empty_status);
			result.setInfo(Status.useraccount_empty_info);
			return result;
		}
		Map<String, Object> param = new HashMap<String,Object>();
		SystemUser account = systemUserMapper.findByUserName(userAccount);
		if(Help.isNotNull(account)&&!account.getnUserId().equals(user.getnUserId())){
			result.setStatus(Status.useraccount_exist_status);
			result.setInfo(Status.useraccount_exist_info);
			return result;
		}
		user.setcUserName(userAccount);
		if(!"********".equals(password))
		user.setcUserPwd(MUtil.md5(password));
		systemUserMapper.updateByPrimaryKey(user);
		userRoleMapper.deleteByUserId(userId);
		List<String> roles = MUtil.convertStringToList(roleCodes);
		for(String roleCode:roles){
			UserRole userRole = new UserRole();
			userRole.setnUserId(userId);
			userRole.setnRoleCode(Integer.parseInt(roleCode));
			userRoleMapper.insertSelective(userRole );
		}
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		return result;
	}

	@Override
	public Result delAdmin(Long userId) {
		// TODO Auto-generated method stub
		Result result = new Result();
		if(Help.isNull(userId)){
			result.setStatus(Status.admin_no_exist_status);
			result.setInfo(Status.admin_no_exist_info);
			return result;
		}
		SystemUser user = systemUserMapper.selectByPrimaryKey(userId);
		if(Help.isNull(user)){
			result.setStatus(Status.admin_no_exist_status);
			result.setInfo(Status.admin_no_exist_info);
			return result;
		}
		systemUserMapper.deleteByPrimaryKey(userId);
		userRoleMapper.deleteByUserId(userId);
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		return result;
	}
	public Result loginInfo(HttpServletRequest request){
		Result result = new Result();
		SystemUser sessionUser = getSessionUser(request);
		sessionUser.setcUserPwd("不告诉你！");
		result.setStatus(Status.success_status);
		result.setInfo(Status.success_info);
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("loginInfo", sessionUser);
		result.setData(data);
		return result;
	}
}
