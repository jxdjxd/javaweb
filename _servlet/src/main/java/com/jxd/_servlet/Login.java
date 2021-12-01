package com.jxd._servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jxd
 * @date 2021/11/1 16:00
 */
@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String userName = (String) req.getParameter("userName");
        String password = (String) req.getParameter("password");

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("登录的用户名为：" + userName);
        resp.getWriter().write("密码为：" + password);
    }
}
