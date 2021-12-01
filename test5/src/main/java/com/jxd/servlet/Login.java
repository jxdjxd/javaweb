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
 * 处理用户登录的Servlet
 * @author jxd
 * @date 2021/11/23 17:48
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

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User u = new User(username,password);

        UserDao userDao = new UserDao();

        User userFromDB = userDao.find(u);
        if(userFromDB != null){
            req.getSession().setAttribute("user",userFromDB);
            req.getRequestDispatcher("/success.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
