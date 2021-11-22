package com.zlt.vo;

import com.zlt.entity.Permission;
import com.zlt.entity.Role;
import com.zlt.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ActiveUser {

    private User user;

    private List<Role> roles;

    private List<Permission> permissions;

}
