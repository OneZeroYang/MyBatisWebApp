package com.yang.web.Land;

import com.google.gson.Gson;
import com.yang.web.BaseHttpSerlet;
import com.yang.web.ResponseBean.RegisterDao;
import com.yang.web.bean.User;
import com.yang.web.dao.UserMapping;
import com.yang.web.dao.db.DbUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注册
 *
 * @author yangshijie
 */
@WebServlet(name = "Register", urlPatterns = "/register")
public class Register extends BaseHttpSerlet {
    @Override
    protected void initPost(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        try {
            UserMapping mapping = getMapping();
            User userById = mapping.getUserById(id);
            RegisterDao dao = new RegisterDao();
            if (userById != null) {
                dao.setCode(500);
                dao.setMsg("该账户已存在！");
            } else {
                mapping.addUser(new User(id, password));
                dao.setCode(200);
                dao.setMsg("注册成功！");
            }
            response.getWriter().write(new Gson().toJson(dao));
            SqlSessionCommit();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void initGet(HttpServletRequest request, HttpServletResponse response) {
    }
}
