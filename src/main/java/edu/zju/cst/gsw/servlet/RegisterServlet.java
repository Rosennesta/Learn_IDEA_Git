package edu.zju.cst.gsw.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class RegisterServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("获取单值参数name:" + req.getParameter("name"));

        String[] gender = req.getParameterValues("gender");
        System.out.println("获取具有多值的参数hobits: " + Arrays.asList(gender));

        System.out.println("通过 getParameterMap 遍历所有的参数： ");
        Map<String, String[]> parameters = req.getParameterMap();

        Set<String> paramNames = parameters.keySet();
        for (String param : paramNames) {
            String[] value = parameters.get(param);
            System.out.println(param + ":" + Arrays.asList(value));
        }
    }
}
