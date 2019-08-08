package com.nifengi.dataclub.web;

import com.nifengi.dataclub.dao.DataFrame;
import com.nifengi.dataclub.service.DataFrameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataFrameController {

    @Autowired
    private DataFrameService dataFrameService;



    //增加一个数据集
    @PostMapping("dataFrame")
    public String postDataFrame(@RequestParam String name, @RequestParam String url, @RequestParam String des, @RequestParam String username){


        if(dataFrameService.postData(name,url,des,username)){
            return "redirect:index";
        }else{
            return null;
        }

    }

    //删除一个数据集
    @GetMapping("deleteDataFrame/{id}")
    public String deleteDataFrame(@PathVariable long id ){
            dataFrameService.deleteOne(id);
            return "redirect:admin";
    }
}
