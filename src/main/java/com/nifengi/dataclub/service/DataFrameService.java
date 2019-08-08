package com.nifengi.dataclub.service;

import com.nifengi.dataclub.dao.DataFrame;
import com.nifengi.dataclub.dao.DataFrameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataFrameService {
    @Autowired
    private DataFrameRepository dataFrameRepository;



    //保存数据集
    public boolean postData(String name, String url, String des, String email){
        DataFrame dataFrame = new DataFrame();
        dataFrame.setName(name);
        dataFrame.setUrl(url);
        dataFrame.setDescription(des);
        dataFrame.setUsername(email);
        if(dataFrameRepository.save(dataFrame)!=null){
            return true;
        }else{
            return false;
        }
    }


    //寻找全部
    public List<DataFrame> findAll(){
        return dataFrameRepository.findAll();
    }
    //根据id找数据集
    public  DataFrame findOne(long id){
        return  dataFrameRepository.findById(id).get();
    }

    //删除一条数据集
    public void deleteOne(long id){
        dataFrameRepository.deleteById(id);
    }

}
