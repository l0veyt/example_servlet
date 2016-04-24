package com.example.servlet.quick_start;

import javax.servlet.*;
import java.util.Enumeration;

/**
 * Created by Xin.Lee on 2016/4/5.
 * Servlet快速入门
 */
public class QuickStart_Servlet implements Servlet {

    /**
     * 初始化  执行一次
     * WEB服务器启动后会解析web.xml的内容
     * 如果web.xml中配置了<load-on-startup>则在启动时就创建Servlet实例
     * 如果web.xml中没有配置，则在当Servlet被访问时再创建实例
     * 创建Servlet实例后会调用init方法初始化，并把web.xml的配置载入到ServletConfig对象中
     */
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("QuickStart_Servlet init...");

        // 获取QuickStart_Servlet这个Servlet的名称，即web.xml中的<servlet-name>
        System.out.println("ServletName:\t" + servletConfig.getServletName());

        // 获取QuickStart_Servlet这个Servlet的初始化参数的值，即web.xml中的<init-param>下的<param-name>所对应的<param-value>
        System.out.println("InitParameter:\t" + servletConfig.getInitParameter("custom_value1"));

        // 获取QuickStart_Servlet这个Servlet的所有初始化参数的名称，即web.xml中的<init-param>下的<param-name>
        Enumeration initParameterNames = servletConfig.getInitParameterNames();
        while(initParameterNames.hasMoreElements()) {
            Object o = initParameterNames.nextElement();
            System.out.println("InitParameterName:\t" + o);
        }

        // 获取全局的上下文对象，域对象（范围为整个web项目）
        servletConfig.getServletContext();
    }

    /**
     * 处理   一次请求就执行一次
     * 创建完Servlet容器后，会将请求响应放到ServletRequest、ServletResponse中，调用service处理相应的业务逻辑
     * servlet的实例在内存中只有一个，是单例的模式，每次请求时web容器都会创建新的线程来执行service方法
     * 当请求到达时，Servlet容器通过调度线程(Dispatcher Thread) 调度它管理下线程池中等待执行的线程（Worker Thread）给请求者
     * 请求结束，放回线程池，等待被调用
     * http://www.cnblogs.com/yjhrem/articles/3160864.html
     */
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("service...");
    }

    /**
     * 销毁   执行一次
     * web服务器关闭或移除项目时销毁Servlet，调用该方法
     */
    public void destroy() {
        System.out.println("destroy...");
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public String getServletInfo() {
        return null;
    }
}
