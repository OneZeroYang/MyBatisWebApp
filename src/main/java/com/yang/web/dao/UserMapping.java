package com.yang.web.dao;

import com.yang.web.bean.User;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface UserMapping {
    @Select("select * from user")
    List<User> findUserById();


    User getUserById(String id);

}
