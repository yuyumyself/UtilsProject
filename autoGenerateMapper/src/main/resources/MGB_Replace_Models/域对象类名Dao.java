package 包名.business.service;

import 包名.business.model.域对象类名;


import java.util.List;

public interface 域对象类名Dao {
    int insert域对象类名(域对象类名 对象名);

    /**
     * 通过多个id批量删除
     * @param list
     * @return
     */
    int del域对象类名(List<String> list) ;

    int update域对象类名(域对象类名 对象名);

    域对象类名 get域对象类名ById(String id);
    /**
     * 根据域对象查询
     */
    List<域对象类名> get域对象类名ByModel(域对象类名 对象名);



}
