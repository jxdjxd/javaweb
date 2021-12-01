<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%! String name = "jxd";
        int age = 20;
        String sex = "男";
    %>
    <table>
        <tr>
            <td>name</td>
            <td><%= name%></td>
        </tr>
        <tr>
            <td>age</td>
            <td><%= age%></td>
        </tr>
        <tr>
            <td>sex</td>
            <td><%= sex%></td>
        </tr>
    </table>
    <br>
<%--    <jsp:include page="date.jsp" flush="true"/>--%>
     <%@ include file="date.jsp"%>
</body>
</html>
