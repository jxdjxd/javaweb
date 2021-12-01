<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login page</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/login">
        用户名：<input type="text" name="userName">
        密码：<input type="password" name="password">
        <input type="submit" value="提交">
    </form>
</body>
</html>
