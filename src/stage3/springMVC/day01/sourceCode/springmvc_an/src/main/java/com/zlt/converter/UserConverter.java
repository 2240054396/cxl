package com.zlt.converter;

import com.zlt.entity.User;
import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class UserConverter implements Converter<String, User> {
    @SneakyThrows
    public User convert(String s) {
        String[] split = s.split(",");
        String username=split[0];
        String password=split[1];
        String birthdayStr=split[2];
        Date birthday=new SimpleDateFormat("yyyy-MM-dd").parse(birthdayStr);
        return new User(username,password,birthday);
    }
}
