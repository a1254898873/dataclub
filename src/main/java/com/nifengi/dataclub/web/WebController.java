package com.nifengi.dataclub.web;

import com.nifengi.dataclub.dao.DataFrame;
import com.nifengi.dataclub.dao.User;
import com.nifengi.dataclub.service.DataFrameService;
import com.nifengi.dataclub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    private UserService userService;

    @Autowired
    private DataFrameService dataFrameService;
    //返回主页
    @RequestMapping("index")
    public String index(@CookieValue(defaultValue = "") String email, Model model){
        model.addAttribute("name",email);
        List<DataFrame> dataFrames = dataFrameService.findAll();
        model.addAttribute("dataFrames",dataFrames);
        return "index";
    }




    //注册页面
    @RequestMapping("register")
    public String userRegister(){
        return "register";
    }


    //登录页面
    @RequestMapping("login")
    public String login(){
        return "login";
    }


    @RequestMapping("logout")
    public String logout(HttpServletResponse response){
        Cookie cookie = new Cookie("email",null);
        response.addCookie(cookie);
        return "redirect:index";
    }



    //展示数据集详细信息
    @RequestMapping("dataFrame/{id}")
    public String showData(@PathVariable long id,Model model){
        DataFrame dataFrame = dataFrameService.findOne(id);
        model.addAttribute("dataFrame",dataFrame);
        return "dataFrame";
    }





}
