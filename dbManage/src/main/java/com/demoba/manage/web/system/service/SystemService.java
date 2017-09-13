package com.demoba.manage.web.system.service;

import javax.servlet.http.HttpServletRequest;

import com.demoba.manage.web.system.model.AddAdminModel;
import com.demoba.manage.web.system.model.AddGroupModel;
import com.demoba.manage.web.system.model.AdminListModel;
import com.demoba.manage.web.system.model.GroupListModel;
import com.demoba.manage.web.system.model.ModifyAdminModel;
import com.demoba.manage.web.system.model.ModifyGroupModel;
import com.owl.common.util.Result;

public interface SystemService {
 public Result login(HttpServletRequest request,String userName,String userPwd);
 public Result getUserMenus(HttpServletRequest request);
 public Result groupList(GroupListModel groupListModel);
 public Result menuTree(Long getnUserId, Long roleCode);
 public Result addGroup(HttpServletRequest request,AddGroupModel addGroupModel);
 public Result roleDetail(Long groupId);
 public Result modifyGroup(HttpServletRequest request,ModifyGroupModel modifyGroupModel);
 public Result delGroup(Long groupId);
 public Result adminList(AdminListModel adminListModel);
 public Result addAdmin(AddAdminModel addAdminModel);
 public Result adminInfo(Long userId);
 public Result modifyAdmin(ModifyAdminModel modifyAdminModel);
 public Result delAdmin(Long userId);
 public Result loginInfo(HttpServletRequest request);
}
