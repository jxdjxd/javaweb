<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>调查问卷</title>
    <link rel="stylesheet" type="text/css" href="css/base.css">
    <link rel="stylesheet" type="text/css" href="css/questionnaire.css">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/questionnaire.js"></script>
</head>
<body>
<div class="w">
    <form action="">
        <table>
            <thead>
            <tr>
                <td>
                    <h1>
                        就业意向调查问卷
                    </h1>
                </td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <label for="name">姓名: </label>
                    <input type="text" name="name" id="name">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="age">年龄: </label>
                    <input type="number" name="age" id="age">
                </td>
            </tr>
            <tr>
                <td>
                    年级:
                    <label for="grade_1">大一</label>
                    <input type="radio" name="grade" value="1" id="grade_1">
                    <label for="grade_2">大二</label>
                    <input type="radio" name="grade" value="2" id="grade_2">
                    <label for="grade_3">大三</label>
                    <input type="radio" name="grade" value="3" id="grade_3">
                    <label for="grade_4">大四</label>
                    <input type="radio" name="grade" value="4" checked="checked" id="grade_4">
                </td>
            </tr>
            <tr>
                <td>
                    性别：
                    <label for="sex_male">男</label>
                    <input type="radio" name="sex" value="male" checked="checked" id="sex_male">
                    <label for="sex_female">女</label>
                    <input type="radio" name="sex" value="female" id="sex_female">
                </td>
            </tr>
            <tr>
                <td>
                    来自：
                    <select name="from">
                        <option selected="selected" value="beijing">北京</option>
                        <option value="nanjing">南京</option>
                        <option value="tianjing">天津</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="提交问卷" id="submit">
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>
