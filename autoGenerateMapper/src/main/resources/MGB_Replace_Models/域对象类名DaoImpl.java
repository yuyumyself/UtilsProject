package 包名.business.dao.impl;


import 包名.business.dao.域对象类名Dao;
import 包名.business.mapper.域对象类名Mapper;

import 包名.business.model.域对象类名;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 
 * @create
 */
@Repository
public class 域对象类名DaoImpl implements 域对象类名Dao {

    @Resource
    private 域对象类名Mapper mapper;
    @Override
    public  int insert域对象类名(域对象类名 对象名){
        return  this.mapper.insert域对象类名(对象名);
    }

    @Override
    public  int del域对象类名(List<String> list){
        return  this.mapper.del域对象类名(list);
    }

    @Override
    public  int update域对象类名(域对象类名 对象名){
        return  this.mapper.update域对象类名(对象名);
    }

    @Override
    public  域对象类名 get域对象类名ById(String id){
        return  this.mapper.get域对象类名ById(id);
    }

    @Override
    public  List<域对象类名> get域对象类名ByModel(域对象类名 对象名){
        return  this.mapper.get域对象类名ByModel(对象名);
    }

}
