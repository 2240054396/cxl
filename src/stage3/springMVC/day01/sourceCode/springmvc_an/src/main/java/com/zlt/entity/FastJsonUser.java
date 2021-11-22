package com.zlt.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FastJsonUser {
    private String username;
    @JSONField(serialize = false)
    private String password;
    @JSONField(format = "yyyy-MM-dd")
    private Date birthday;

    public FastJsonUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
