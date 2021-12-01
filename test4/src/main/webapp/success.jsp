<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>success page</title>
</head>
<body>
    <h1>登录成功！</h1>

    <hr>
    <h3>从session域中获取到的信息：</h3>
    <p>用户名：${sessionScope.username}</p>
    <p>密码：${sessionScope.password}</p>
</body>
</html>
