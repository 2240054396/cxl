package com.zlt.springboot2;

import com.zlt.springboot2.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Date;

@SpringBootTest
class Springboot2ApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        User user=new User(1L,"zhangsan","123456","cool",new Date(),21);
        redisTemplate.opsForValue().set("user",user);
    }

}
