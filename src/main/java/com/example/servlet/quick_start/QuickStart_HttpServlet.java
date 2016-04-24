package com.example.servlet.quick_start;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Xin.Lee on 2016/4/5.
 * HttpServlet快速入门
 */
public class QuickStart_HttpServlet extends HttpServlet {

    /**
     *  Servlet -- GenericServlet -- HttpServlet -- QuickStart_HttpServlet
     *  GenericServlet:与协议无关，通过继承该类即可完成Servlet的任务
     *  HttpServlet:与Http协议有关，是对Http进行了相关的封装
     *
     *  HttpServlet通过在复写继承的service方法来将req、res强转为相应的HttpReq、HttpRes
     *  并调用自身的重载的service方法
     *  来根据不同的请求方式调用不用的方法
     *  例如：GET请求就调用doGet方法，POST请求就调用doPost方法
     *  所以我们只需要继承HttpServlet，复写doGet、doPost方法，在内部编写我们自己的业务逻辑即可
     *
     *  service(ServletRequest,ServletResponse) -- service(HttpServletRequest,HttpServletResponse) -- doGet、doPost、doDelete等
     */

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        service(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void init() throws ServletException {
        System.out.println("QuickStart_HttpServlet init...");
    }
}
