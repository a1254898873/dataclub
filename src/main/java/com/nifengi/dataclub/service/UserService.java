package com.nifengi.dataclub.service;

import com.nifengi.dataclub.dao.User;
import com.nifengi.dataclub.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    //保存用户信息
    public User userSave(User user){
       return  userRepository.save(user);
    }


    //检查登录
    public boolean userFind(String email,String password){
        User user = userRepository.findByEmail(email).get(0);
        String ps = user.getPassword();

        if(ps.equals(password)){
            return true;
        }else{
            return false;
        }
    }

}
