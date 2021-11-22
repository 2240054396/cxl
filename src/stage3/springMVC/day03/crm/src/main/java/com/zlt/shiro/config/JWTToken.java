package com.zlt.shiro.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.shiro.authc.AuthenticationToken;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class JWTToken implements AuthenticationToken {
    private String token;

    public Object getPrincipal() {
        return token;
    }

    public Object getCredentials() {
        return token;
    }
}
