package com.yang.web.dao;

import com.yang.web.bean.User;
import com.yang.web.bean.UserInFo;
import org.apache.ibatis.annotations.Select;


import java.util.List;

/**
 * @author yangshijie
 */
public interface UserMapping {
    /**
     * @return
     */
    @Select("select * from user")
    List<User> findUserById();


    /**
     * @param id
     * @return
     */
    User getUserById(String id);

    void addUser(User user);

    void addinfo(UserInFo userInFo);



}
