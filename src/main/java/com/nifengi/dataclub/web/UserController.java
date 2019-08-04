package com.nifengi.dataclub.web;


import com.nifengi.dataclub.dao.User;
import com.nifengi.dataclub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //返回主页
    @RequestMapping("index")
    public String index(){
        return "index";
    }


    //后台管理页面
    @RequestMapping("admin")
    public String admin(){
        return "admin";
    }

    //注册页面
    @RequestMapping("register")
    public String UserRegister(){
        return "register";
    }


    //保存用户信息
    @PostMapping("user")
    public  String userSave(User user){
       User result= userService.userSave(user);
       if(result !=null){
           return "index";
       }else{
           return null;
       }
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }


    //登录
    @GetMapping("user")
    public String userFind(@RequestParam String email , @RequestParam String password, HttpServletResponse response){

        boolean result = userService.userFind(email,password);

        if(result){
            Cookie cookie = new Cookie("email",email);
            response.addCookie(cookie);
            return "index";
        }else{
            return null;
        }



    }



}
