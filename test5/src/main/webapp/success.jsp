<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success page</title>
</head>
<body>
    <h3>从session域中获取到的数据：</h3>
    <p>用户名：${sessionScope.user.username}</p>
    <p>密码：${sessionScope.user.password}</p>
</body>
</html>
