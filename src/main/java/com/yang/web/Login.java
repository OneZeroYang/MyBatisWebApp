package com.yang.web;

import com.google.gson.Gson;
import com.yang.web.ResponseBean.B_Login;
import com.yang.web.bean.User;
import com.yang.web.dao.UserMapping;
import com.yang.web.dao.db.DbUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class Login extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        System.out.println(id);
        System.out.println(password);
        try {
            SqlSession sqlSession = DbUtils.getSqlSession();
            UserMapping mapper = sqlSession.getMapper(UserMapping.class);
            User userById = mapper.getUserById(id);
            String password1 = userById.getPassword();
//            PrintWriter writer = response.getWriter();
            response.setHeader("Content-Type","text/html;charset=utf-8");
            B_Login ml=new B_Login();
            if (password1.equals(password)){
                ml.setCode(200);
                ml.setMsg("登陆成功！");

            }else {
                ml.setCode(200);
                ml.setMsg("账号或密码错误！");
            }
            String json= new Gson().toJson(ml);
            response.getWriter().write(json);
        }catch (Exception e){

        }


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        doPost(request,response);
    }
}
