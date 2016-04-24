package com.example.servlet.servlet_read;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Xin.Lee on 2016/4/23.
 * 根据磁盘路径读取资源文件(使用较多)
 */
public class ReadRealPath_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        // 根据webapp中的绝对路径获取文件磁盘绝对路径
        String realPath = context.getRealPath("/WEB-INF/classes/db.properties");
        File f = new File(realPath);
        FileInputStream fis = new FileInputStream(f);
        Properties p = new Properties();
        p.load(fis);
        String username = p.getProperty("username");
        String password = p.getProperty("password");
        resp.getWriter().write("Username:" + username + "\r" + "Password:" + password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
