package com.nifengi.dataclub.web;

import com.nifengi.dataclub.dao.DataFrame;
import com.nifengi.dataclub.dao.User;
import com.nifengi.dataclub.service.DataFrameService;
import com.nifengi.dataclub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class ManageController {

    @Autowired
    private UserService userService;

    @Autowired
    private DataFrameService dataFrameService;

    //后台管理页面
    @RequestMapping("admin")
    public String admin(Model model){
        List<DataFrame> dataFrames = dataFrameService.findAll();
        model.addAttribute("dataFrames",dataFrames);
        return "admin";
    }

    //用户管理页面
    @RequestMapping("userManage")
    public String user(Model model){
        List<User> user = userService.findAll();
        model.addAttribute("user",user);
        return "user";
    }


    //添加数据集页面
    @RequestMapping("addDataFrame")
    public String addData(@CookieValue String email, Model model){
        model.addAttribute("email",email);
        return "addData";
    }

    //更新数据集
    @RequestMapping("updateDataFrame/{id}")
    public String updateData(@PathVariable long id, Model model){
        DataFrame dataFrame = dataFrameService.findOne(id);
        model.addAttribute("dataFrame",dataFrame);
        return "updateData";
    }


    //删除数据集
    @RequestMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable long id){
        userService.deleteUser(id);
        return "user";
    }


}
