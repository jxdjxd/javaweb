package com.jxd.servlet;

import com.jxd.bean.User;
import com.jxd.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理用户注册的Servlet
 * @author jxd
 * @date 2021/11/23 18:00
 */
@WebServlet("/regist")
public class Regist extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        UserDao userDao = new UserDao();

        User u = new User(req.getParameter("username"),req.getParameter("password"));
        if(userDao.insert(u)){
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }else{
            resp.getWriter().write("注册用户失败！");
        }
    }
}
