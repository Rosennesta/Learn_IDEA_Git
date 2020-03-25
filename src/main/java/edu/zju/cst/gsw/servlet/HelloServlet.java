package edu.zju.cst.gsw.servlet;

import org.joda.time.DateTime;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class HelloServlet extends HttpServlet {
    public HelloServlet() {
        System.out.println("Ctor Invoked!");
    }

    @Override
    public void destroy() {
        System.out.println("Destroyed!");
    }

    @Override
    public void init(ServletConfig config) {
        System.out.println("Initiate Hello Servlet!");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {

        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            String value = req.getHeader(header);
            System.out.printf("%s\t%s%n", header, value);
        }
        try {
            resp.getWriter().println("<h1>Hello Servlet!</h1>");
            resp.getWriter().println(DateTime.now());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
