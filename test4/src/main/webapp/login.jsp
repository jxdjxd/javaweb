<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login page</title>
</head>
<body>
    <form action="login" method="post">
        <label><input type="text" name="username" value="${cookie.username.value}"></label>
        <label><input type="password" name="password"></label>
        <input type="submit" value="提交">
    </form>
</body>
</html>
