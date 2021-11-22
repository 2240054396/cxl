package com.zlt.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserVo {
    private Long uid;

    private String username;

    private String password;

    private String salt;

    private String nickname;
}
