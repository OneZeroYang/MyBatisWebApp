package com.yang.web;

import com.yang.web.dao.UserMapping;
import com.yang.web.dao.db.DbUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class BaseHttpSerlet extends HttpServlet {
    private SqlSession sqlSession = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // super.doGet(request, response);
        initResponse(response);
        initGet(request, response);
        doPost(request,response);
    }

    protected void initResponse(HttpServletResponse response) {
        response.setHeader("Content-Type", "text/html;charset=utf-8");
    }

    protected abstract void initGet(HttpServletRequest request, HttpServletResponse response);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // super.doPost(request, response);
        initResponse(response);
        initPost(request, response);
    }

    protected abstract void initPost(HttpServletRequest request, HttpServletResponse response);

    protected UserMapping getMapping() {
        UserMapping mapper = null;
        try {
            if (sqlSession == null) {
                sqlSession = DbUtils.getSqlSession();
            }
            mapper = sqlSession.getMapper(UserMapping.class);

        } catch (Exception e) {

        }
        return mapper;
    }

    protected void SqlSessionCommit() {
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
            sqlSession = null;
        }
    }
}
