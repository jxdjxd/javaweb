package com.jxd.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 *其他servlet类可以集成此BaseServlet，就可以根据请求中的method参数的值调用对应的方法
 * 例如：/UserServlet?method=userLogin 将调用UserServlet中的userLogin方法
 *
 * @author jxd
 * @date 2021.11.21
 */
@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BaseServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 利用反射，调用和response对象中method参数的值相同的方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        try{
            // 利用反射，获取方法名和method参数的值相同的方法对象
            Method method2 = this.getClass().getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
            method2.setAccessible(true);
            // 那个servlet调用，就执行那个servlet中指定的方法
            method2.invoke(this,request,response);
            return;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
