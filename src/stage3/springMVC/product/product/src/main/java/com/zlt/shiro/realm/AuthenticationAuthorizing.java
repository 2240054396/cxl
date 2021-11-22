package com.zlt.shiro.realm;

import com.zlt.entity.daoEntity.User;
import com.zlt.utils.JWTUtils;
import com.zlt.utils.MD5Util;
import com.zlt.utils.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationAuthorizing extends AuthorizingRealm {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean supports(AuthenticationToken token) {
        return super.supports(token);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getPrincipal();
        if (!StringUtils.isNotNull(token)) {
            throw new AuthenticationException("no token found");
        }
        User user=(User)redisTemplate.opsForValue().get("username:"+JWTUtils.getUsername(token));
        if (user==null){
            throw new AuthenticationException("no this user");
        }
        if (!JWTUtils.verify(token,JWTUtils.getUsername(token), MD5Util.md5(user.getPassword(),user.getSalt(),10))){
            throw new AuthenticationException("password in your token wrong for user:"+JWTUtils.getUsername(token));
        }
        if (JWTUtils.isExpire(token)){
            throw new AuthenticationException("your token is expired");
        }

        return new SimpleAuthenticationInfo(user,token,"Authentication");
    }
}
