package edu.zju.cst.gsw.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        System.out.println("浏览器发出请求时的完整URL，包括协议 主机名 端口(如果有): " + req.getRequestURL());
        System.out.println("浏览器发出请求的资源名部分，去掉了协议和主机名: " + req.getRequestURI());
        System.out.println("请求行中的参数部分: " + req.getQueryString());
        System.out.println("浏览器所处于的客户机的IP地址: " + req.getRemoteAddr());
        System.out.println("浏览器所处于的客户机的主机名: " + req.getRemoteHost());
        System.out.println("浏览器所处于的客户机使用的网络端口: " + req.getRemotePort());
        System.out.println("服务器的IP地址: " + req.getLocalAddr());
        System.out.println("服务器的主机名: " + req.getLocalName());
        System.out.println("得到客户机请求方式: " + req.getMethod());

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println("username = " + username);
        System.out.println("password = " + password);

//        String html = "";
        if ("admin".equals(username) && "123".equals(password)) {
//            html = "<div style='color:green'>成功</div>";
            req.getRequestDispatcher("success.html").forward(req, resp);
        } else {
//            html = "<div style='color:red'>失败</div>";
            resp.sendRedirect("failed.html");
        }
//        resp.setContentType("text/html; charset=UTF-8");
//        PrintWriter writer = resp.getWriter();
//        writer.write(html);
    }
}
