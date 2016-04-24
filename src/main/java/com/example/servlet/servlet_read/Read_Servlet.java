package com.example.servlet.servlet_read;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Xin.Lee on 2016/4/23.
 * 根据相对路径读取资源文件
 */
public class Read_Servlet extends HttpServlet {

    /**
     * 读取配置文件Properties
     * 在Servlet下读取配置文件获取输入流使用ServletContext的getResourceAsStream
     * 因为是web项目，默认路径（即 ./ 当前路径）为webapp下
     * 所以要找到资源文件的路径变成了/WEB-INF/classes
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream is = getServletContext().getResourceAsStream("./WEB-INF/classes/db.properties");
        Properties p = new Properties();
        p.load(is);
        String username = p.getProperty("username");
        String password = p.getProperty("password");
        resp.getWriter().write("Username:" + username + "\r" + "Password:" + password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * 读取配置文件Properties
     * 在IDEA中默认路径（即 ./ 当前路径）为项目目录下
     * 所以要找到resources资源文件下的文件，使用相对路径就要写成src/main/resources
     */
    public static void main(String[] args) throws IOException {
        File f = new File("src/main/resources/db.properties");
        FileInputStream fis = new FileInputStream(f);
        Properties p = new Properties();
        p.load(fis);
        String username = p.getProperty("username", "lix");
        String password = p.getProperty("password", "123456");
        System.out.println("username:" + username + "\t" + "password:" + password);
    }
}
