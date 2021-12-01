<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <a href="hello-servlet">Hello Servlet</a>
    <br>
    <a href="questionnaire.jsp">填写调查问卷</a>
    <br>
    <a>
        <button value="点击获取session中message变量中的值"></button>
    </a>
</body>
<script>
    document.getElementsByName("button")[0].addEventListener('click', function (){
        alert(${message});
    }, false);
</script>
</html>