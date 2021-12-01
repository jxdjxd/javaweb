package com.jxd.servlet;

import com.jxd.bean.User;
import com.jxd.service.UserService;
import com.jxd.service.impl.UserServiceImpl;
import com.jxd.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jxd
 * @date 2021/11/22 10:36
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet{
    private static final long serialVersionUID = 1L;
    /**
     * 处理用户登录的Servlet方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void User_login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService us = new UserServiceImpl();

        request.setCharacterEncoding("utf-8");
        User user = WebUtils.param2bean(request, new User());

        String rightCode = (String) request.getSession().getAttribute("code");
        if(!request.getParameter("code").equalsIgnoreCase(rightCode)){
            request.setAttribute("message","验证码错误！");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

        User userFromDB = us.login(user);
        if (userFromDB == null){
            //登录失败，转发到登录页面
            request.setAttribute("message", "用户名或密码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }else{
            //登录成功，重定向到成功页
            request.getSession().setAttribute("user",userFromDB);
            response.sendRedirect("success.jsp");
            return;
        }
    }

    protected void User_regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService us = new UserServiceImpl();

        request.setCharacterEncoding("utf-8");
        User user = WebUtils.param2bean1(request, new User());

        if (us.regist(user)) {
            //注册成功，重定向到登录页面
            response.sendRedirect("index.jsp");
        }else{
            //注册失败，转发
            request.setAttribute("message","注册失败！");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
