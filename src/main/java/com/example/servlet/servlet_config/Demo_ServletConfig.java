package com.example.servlet.servlet_config;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Xin.Lee on 2016/4/6.
 *
 */
public class Demo_ServletConfig extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Demo_ServletConfig doGet...");
        // 因为继承了GenericServlet，所以继承了getServletConfig方法
        // GenericServlet实例在被创建的时候调用init方法，将config存入了this.config
        ServletConfig servletConfig = getServletConfig();
        resp.setCharacterEncoding(servletConfig.getInitParameter("custom_encoding"));
    }

}
