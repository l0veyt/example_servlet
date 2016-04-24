package com.example.servlet.servlet_context;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Xin.Lee on 2016/4/6.
 *
 */
public class Demo_ServletContext extends HttpServlet {

    /**
     * ServletContext:web容器启动时会为每一个web应用创建一个servletContext对象
     * 概念：它代表一个web应用，被WEB应用内的所有资源共享（包括HTML、JSP）
     * 通过ServletConfig获取ServletContext的对象，servlet对象之间可以通过ServletContext来实现通讯，数据共享、读取资源文件
     */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Demo_ServletContext doGet...");
        // 获取全局的初始化参数
        String contextInitParameter = getServletConfig().getServletContext().getInitParameter("context_value");
        System.out.println(contextInitParameter);

        // 获取全局初始化参数，因为GenericServlet中有getServletContext方法，其中也是调用了getServletConfig方法获取
        Enumeration contextInitParameterNames = getServletContext().getInitParameterNames();
        while(contextInitParameterNames.hasMoreElements()) {
            Object o = contextInitParameterNames.nextElement();
            System.out.println("ContextInitParameterName:\t" + o);
        }
    }
}