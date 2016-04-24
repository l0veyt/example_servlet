package com.example.servlet.servlet_context;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Xin.Lee on 2016/4/18.
 *
 */
public class CountServletDemo1 extends HttpServlet {

    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute("visit_count", 0);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer count = (Integer)getServletContext().getAttribute("visit_count");
        getServletContext().setAttribute("visit_count", ++count);

        // 向页面输出内容
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("访问成功！");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
