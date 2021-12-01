package com.jxd._servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jxd
 * @date 2021/11/1 14:54
 */
@WebServlet("/secondServlet")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("secondServlet获取到firstServlet中的信息为：" + req.getAttribute("firstServlet"));
        req.setAttribute("secondServlet", "这是secondServlet添加的内容");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
