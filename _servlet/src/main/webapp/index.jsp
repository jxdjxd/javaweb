<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>index page</title>
</head>
<body>
  <a href="${pageContext.request.contextPath}/firstServlet">对FirstServlet发起一个请求，会转发到SecondServlet，每一个servlet都会在request域中添加信息</a>
  <br>
  <a href="${pageContext.request.contextPath}/thirdServlet">对thirdServlet发起请求，重定向到index.jsp</a>
  <hr>
  <p>
    request域对象中的数据:
    <br>
    firstServlet:<%=request.getAttribute("firstServlet")%>
    <br>
    secondServlet:<%=request.getAttribute("secondServlet")%>
    <br>
    thirdServlet:<%=request.getAttribute("thirdServlet")%>
  </p>
</body>
</html>