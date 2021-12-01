<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register page</title>
</head>
<body>
    <p>${message==null ? "":message}</p>
    <form action="UserServlet?method=User_regist" method="post">
        <label>用户名：<input name="username" type="text"></label><br>
        <label>密码：<input name="password" type="password"></label><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
