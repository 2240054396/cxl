package com.zlt.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;

@RestController
public class UserController {

    @Autowired
    DruidDataSource dataSource;

    @GetMapping("hello")
    public String hello() throws SQLException {
        DruidPooledConnection connection = dataSource.getConnection();
        return "hello";
    }
}
