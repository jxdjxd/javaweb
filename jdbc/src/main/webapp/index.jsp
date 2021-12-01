<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/style.css" />
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/index.js"></script>
    <title>Document</title>
</head>
<body>
<div class=".bigbox">
    <form action="UserServlet?method=User_login" class="login" method="post">
        <h1>${message==null ? "Login":message}</h1>
        <img src="img/user.png" alt="">
        <input type="text" id="userName" name="username" placeholder="用户名" required />
        <img src="img/lock.png" alt="">
        <input type="password" id="password" name="password" placeholder="密码" required />
        <img src="img/vrfcCode.png" alt="验证码小图标">
        <input type="text" id="VarCode" name="code" placeholder="验证码" required>
        <img id="codeImg" src="getCode" alt="验证码图片">
        <input type="submit"  class="btn" value="登录" />
        <a href="register.jsp">没有账号，去注册-></a>
    </form>
</div>
</body>
</html>
