package com.zlt.entity;

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
public class User {
    private String username;
    @JsonIgnore
    private String password;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
