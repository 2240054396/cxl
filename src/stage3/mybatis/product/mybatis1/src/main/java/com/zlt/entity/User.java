package com.zlt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Long uid;

    private String tbUsername;

    private String password;

    private String nickname;

    private String email;

    private Date regtime;

    private Date logintime;

    private String photo;

    private String salt;
}
