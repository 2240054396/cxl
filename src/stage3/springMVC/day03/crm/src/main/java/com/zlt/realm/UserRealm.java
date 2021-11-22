package com.zlt.realm;

import com.zlt.entity.Role;
import com.zlt.service.UserService;
import com.zlt.entity.User;
import com.zlt.utils.JWTUtils;
import com.zlt.vo.ActiveUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zlt.shiro.config.JWTToken;

import java.util.List;

@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;


    @Override
    public String getName() {
        return "myRealm";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * right
     *
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * certification
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        String username = JWTUtils.getUsername(token);
        if (token == null || token.isEmpty()) {
            throw new AuthenticationException("token失效");
        }
        if (username == null || username.isEmpty()) {
            throw new AuthenticationException("token无效");
        }
        User user = userService.getUserByUserName(username);
        if (user == null) {
            throw new AuthenticationException("qq数据库中无该username2");
        }
        if (!JWTUtils.verify(token, username, user.getPassword())) {
            throw new AuthenticationException("verify 错误");
        }
        if (JWTUtils.isExpire(token)) {
            throw new AuthenticationException("token过期");
        }

        ActiveUser activeUser = new ActiveUser();
        activeUser.setUser(user);
        List<Role> roles=userService.selectRolesByUid(user.getUid());
        activeUser.setRoles(roles);
        activeUser.setPermissions(userService.selectPermissionByRoles(roles));
        return new SimpleAuthenticationInfo(activeUser, token, getName());
    }
}
