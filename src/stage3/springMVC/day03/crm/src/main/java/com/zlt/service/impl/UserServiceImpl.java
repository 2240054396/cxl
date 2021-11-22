package com.zlt.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlt.entity.Permission;
import com.zlt.entity.Role;
import com.zlt.entity.User;
import com.zlt.entity.UserExample;
import com.zlt.mapper.PermissionMapper;
import com.zlt.mapper.RoleMapper;
import com.zlt.mapper.UserMapper;
import com.zlt.service.UserService;
import com.zlt.shiro.config.JWTToken;
import com.zlt.utils.JWTUtils;
import com.zlt.utils.MD5Util;
import com.zlt.utils.PermissionArrayList;
import com.zlt.utils.StringUtils;
import com.zlt.vo.MenuInfo;
import com.zlt.vo.MenuVo;
import com.zlt.vo.ActiveUser;
import com.zlt.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    public User getUserByUserName(String username) {
        User user = (User) redisTemplate.opsForValue().get("username:" + username);
        if (user==null){
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andUsernameEqualTo(username);
            List<User> users = userMapper.selectByExample(userExample);
            user= users != null && !users.isEmpty() ? users.get(0) : null;
            if (user!=null)
            redisTemplate.opsForValue().set("username:"+username,user);
        }
        return user;
    }

    public String login(String username, String password) {

        User user = getUserByUserName(username);

        if (user == null) {
            throw new AuthenticationException("数据库中无该username1");
        }
        String s = MD5Util.md5(password, user.getSalt(), 10);
        String token = JWTUtils.sign(username, s);
        SecurityUtils.getSubject().login(new JWTToken(token));
        return token;
    }

    @Override
    public List<Role> selectRolesByUid(Long uid) {
        List range = redisTemplate.opsForList().range("roles" + uid, 0, -1);
        if (range == null || range.isEmpty()) {
            range = roleMapper.selectRolesByUid(uid);
            redisTemplate.opsForList().rightPushAll("roles" + uid, range);
        }
        return range;
    }

    @Override
    public List<Permission> selectPermissionByRid(Long rid) {
        List range = redisTemplate.opsForList().range("roleId" + rid, 0, -1);
        if (range == null || range.isEmpty()) {
            range = permissionMapper.selectPermissionByRid(rid);
            redisTemplate.opsForList().rightPushAll("roleId" + rid, range);
        }
        return range;
    }

    @Override
    public List<Permission> selectPermissionByRoles(List<Role> roles) {
        PermissionArrayList list = new PermissionArrayList();
        for (Role role : roles) {
            List<Permission> permissions = permissionMapper.selectPermissionByRid(role.getRid());
            for (Permission permission : permissions) {
                if (!list.contains(permission)) {
                    list.add(permission);
                }
            }
        }
        return list;
    }

    @Override
    public MenuVo getMenu() {
        ActiveUser activeUser = (ActiveUser) SecurityUtils.getSubject().getPrincipal();
        if (activeUser == null) {
            return null;
        }
        MenuVo menuVo = new MenuVo();
        MenuInfo homeInfo = new MenuInfo();
        homeInfo.setTitle("首页");
        homeInfo.setHerf("page/welcome-1.html?t=1");
        menuVo.setHomeInfo(homeInfo);
        MenuInfo logoInfo = new MenuInfo();
        logoInfo.setTitle("CRM");
        logoInfo.setImage("images/logo.png");
        logoInfo.setHerf("");
        menuVo.setLogoInfo(logoInfo);
        List<MenuInfo> menuInfo = new ArrayList<>();
        MenuInfo changhui = new MenuInfo();
        changhui.setMid(0L);
        changhui.setLevel(0);
        changhui.setTitle("常规管理");
        changhui.setIcon("fa fa-address-book");
        changhui.setHerf("");
        changhui.setTarget("_self");
        List<MenuInfo> child = new ArrayList<>();
        List<Permission> permissions = activeUser.getPermissions();
        for (Permission permission : permissions) {
            if (permission.getLevels().equals(1)) {
                child.add(new MenuInfo(permission.getPid(), permission.getLevels(), permission.getPname(),
                        permission.getIcon(), permission.getUrl(), permission.getTarget(), "", null));

            }
        }
        for (MenuInfo menu : child) {
            for (Permission permission : permissions) {
                if (permission.getLevels().equals(2) && permission.getParentId().equals(menu.getMid())) {
                    if (menu.getChild() == null) {
                        menu.setChild(new ArrayList<>());
                    }
                    menu.getChild().add(new MenuInfo(permission.getPid(), permission.getLevels(), permission.getPname(),
                            permission.getIcon(), permission.getUrl(), permission.getTarget(), "", null));
                }
            }
        }
        changhui.setChild(child);
        menuInfo.add(changhui);
        menuVo.setMenuInfo(menuInfo);
        return menuVo;
    }

    @Override
    public PageInfo<UserVo> select(Integer pageNow, Integer limit, String username, String nickname) {
        PageHelper.startPage(pageNow,limit);

        UserExample userExample=new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (StringUtils.isNotNull(username)){
            criteria.andUsernameEqualTo(username);
        }
        if (StringUtils.isNotNull(nickname)){
            criteria.andNicknameLike("%"+nickname+"%");
        }
        List<User> users = userMapper.selectByExample(userExample);
        PageInfo<User> pageInfo=new PageInfo<>(users);

        PageInfo<UserVo> pageInfo2=new PageInfo<UserVo>();

        BeanUtils.copyProperties(pageInfo,pageInfo2);
        log.debug("分页的数据为{}",pageInfo2);
        return pageInfo2;
    }
}
