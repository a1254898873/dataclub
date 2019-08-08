package com.nifengi.dataclub.web;


import com.nifengi.dataclub.dao.User;
import com.nifengi.dataclub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    private UserService userService;




    //保存用户信息
    @PostMapping("user")
    public  String userSave(User user){
       User result= userService.userSave(user);
       if(result !=null){
           return "redirect:index";
       }else{
           return null;
       }
    }






    //登录
    @GetMapping("user")
    public String userFind(@RequestParam String email , @RequestParam String password, HttpServletResponse response){

        boolean result = userService.userFind(email,password);

        if(result){
            Cookie cookie = new Cookie("email",email);
            response.addCookie(cookie);
            return "redirect:index";
        }else{
            return null;
        }



    }



}
