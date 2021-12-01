package com.jxd.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jxd
 * @date 2021/11/23 14:30
 */
@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.getSession().setAttribute("username",req.getParameter("username"));
        req.getSession().setAttribute("password",req.getParameter("password"));

        Cookie cookie = new Cookie("username", req.getParameter("username"));
        cookie.setMaxAge(30); //设置cookie的时效为30秒
        resp.addCookie(cookie);

        req.getRequestDispatcher("/success.jsp").forward(req,resp);
    }
}
