package com.zlt.springboot2.entity;

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
    private String username;
    private String password;
    private String introduce;
    private Date birthday;
    private Integer age;
}
