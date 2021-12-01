package com.jxd.chapter05.example01;
import java.io.*;
import java.util.Collection;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ListBookServlet")
public class ListBookServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		Collection<Book> books = BookDB.getAll();
		out.write("本站提供的图书有：<br>");
		for (Book book : books) {
			String url = "/PurchaseServlet?id=" + book.getId();
			HttpSession s=req.getSession();
			String newUrl=resp.encodeRedirectURL(url);
			out.write(book.getName() + "<a href='" + newUrl + "'>点击购买</a><br>");
		}
	}

}
