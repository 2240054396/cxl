package com.zlt.service;

import com.github.pagehelper.PageInfo;
import com.zlt.entity.Permission;
import com.zlt.entity.Role;
import com.zlt.entity.User;
import com.zlt.vo.MenuVo;
import com.zlt.vo.UserVo;

import java.util.List;

public interface UserService {
    User getUserByUserName(String username);

    String login(String username, String password);

    MenuVo getMenu();

    List<Role> selectRolesByUid(Long uid);

    List<Permission> selectPermissionByRoles(List<Role> roles);

    List<Permission> selectPermissionByRid(Long rid);

    PageInfo<UserVo> select(Integer pageNow, Integer limit, String username, String nickname);
}
