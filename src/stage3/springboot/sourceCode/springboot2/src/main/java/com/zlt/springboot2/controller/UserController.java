package com.zlt.springboot2.controller;

import com.zlt.springboot2.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
@CrossOrigin()
public class UserController {
    @GetMapping("hello")
    public String hello(ModelMap map) {
        String qwe=null;
        qwe.toString();
        //放了一个对象在ModelMap中
        map.addAttribute("user", new User(1L, "zhangsan", "123456", "<b>我是张三</b>", new Date(), 18));
        List<User> users = new ArrayList<>();
        users.add(new User(2L, "zhangsan1", "123456", "<b>我是张三</b>", new Date(), 18));
        users.add(new User(3L, "zhangsan2", "123456", "<b>我是张三</b>", new Date(), 18));
        users.add(new User(4L, "zhangsan3", "123456", "<b>我是张三</b>", new Date(), 18));
        users.add(new User(5L, "zhangsan4", "123456", "<b>我是张三</b>", new Date(), 18));
        users.add(new User(6L, "zhangsan5", "123456", "<b>我是张三</b>", new Date(), 18));
        users.add(new User(7L, "zhangsan6", "123456", "<b>我是张三</b>", new Date(), 18));
        users.add(new User(8L, "zhangsan7", "123456", "<b>我是张三</b>", new Date(), 18));
        map.addAttribute("users", users);
        map.addAttribute("pageCount", 5);
        return "user";
    }

    @GetMapping("download")
    public void download(HttpServletResponse response) {
        String path = getClass().getClassLoader().getResource("static/a.jpg").getPath();
        log.debug("路径为{}"+path);
        String filename="a.jpg";
        InputStream is=null;
        ServletOutputStream os=null;
        try {
            URLEncoder.encode(filename,"utf-8");
            response.setHeader("content-disposition", "attachment;filename=" + filename);
            is=new FileInputStream(path);
            os=response.getOutputStream();
            int len=0;
            byte[] bytes=new byte[1024];
            while ((len=is.read(bytes))!=-1){
                os.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (is!=null&&os!=null){
                    is.close();
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @PostMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file){
        String path="D:\\study\\javaProject\\cxl\\src\\stage3\\springboot\\sourceCode\\" +
                "springboot2\\src\\main\\resources\\static\\download";
        String originalFilename=file.getOriginalFilename();
        String filename=path+originalFilename+ UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
        try {
            file.transferTo(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "user";
    }
}
