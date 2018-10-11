package com.yang.web.Land;

import com.yang.web.BaseHttpSerlet;
import com.yang.web.bean.UserInFo;
import org.apache.ibatis.annotations.Select;

import javax.jws.WebService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 完善个人信息
 * @author yangshijie
 */

@WebServlet(name = "PerfectInFo", urlPatterns = "/prfectinfo")
public class PerfectInFo extends BaseHttpSerlet {

    @Override
    protected void initGet(HttpServletRequest request, HttpServletResponse response) {

        getMapping().addinfo(new UserInFo("123","123",12,"4564","4545","454","4556"));
        SqlSessionCommit();

    }

    @Override
    protected void initPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
