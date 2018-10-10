package com.yang.web;



import com.yang.web.bean.User;
import com.yang.web.dao.UserMapping;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class test {

    public static void main(String[] args) throws Exception {


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();


     //   User mapper = sqlSession.getMapper(User.class);
        UserMapping mapper = sqlSession.getMapper(UserMapping.class);
      //  User userById = mapper.findUserById("123123");

        List<User> userById = mapper.findUserById();
//        User idById = mapper.getUserById("123123");
//        String password = idById.getPassword();



        mapper.addUser(new User("123","123"));
//        System.out.print(userById.getPassword());
        System.out.println(userById);
//
//        System.out.print("==="+password);
      //  sqlSession.commit();
        sqlSession.close();
    }
}
