package com.yang.web.Land;

import com.yang.web.BaseHttpSerlet;
import com.yang.web.TokenUtils.TokenManage;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 查询用户信息
 * @author yangshijie
 */

@WebServlet(urlPatterns = "/getuserinfo")
public class GetUserInfo extends BaseHttpSerlet {
    @Override
    protected void initGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void initPost(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
   //     String token = request.getHeader("token");
        String token = request.getParameter("token");
        boolean b = TokenManage.VerificationToken(id, token);
        System.out.print(b);
        if (b){

        }else {

        }

    }
}
