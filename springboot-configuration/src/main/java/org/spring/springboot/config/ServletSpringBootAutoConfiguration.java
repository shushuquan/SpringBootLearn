package org.spring.springboot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Configuration
public class ServletSpringBootAutoConfiguration {
    // HTTP 通信服务
    @Bean("jsonHttpTransportListener")
    public ServletRegistrationBean<JsonHttpTransportListener> createJsonHttpTransportListener()
    {
        log.info("**** create jsonHttpTransportListener at /json-api...");
        ServletRegistrationBean<JsonHttpTransportListener> bean = new ServletRegistrationBean<>(
                new JsonHttpTransportListener());
        bean.addInitParameter("transportController", "defaultRecvTransportController"); // 禁用动态路由
        bean.addUrlMappings("/json-api");
        return bean;
    }
}


class JsonHttpTransportListener extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if(req.getMethod().contentEquals("get"))
        System.out.println(req.getMethod());
        System.out.println(req.getHeaderNames());
        System.out.println(resp.getStatus());
//        resp.sendRedirect("nihao");
        PrintWriter out = resp.getWriter();//取得输出流
        out.println("<html>");//输出的内容要放在HTML中
        out.println("<body>");
        out.println("hello world.........");
        out.println("</body>");
        out.println("</html>");
    }
}

