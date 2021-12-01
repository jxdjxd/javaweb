$(function () {
    $("input#submit").click(function () {

        var userName = $("input#name").val();
        var userAge = $("input#age").val();

        reg_userName = /^[a-z0-9A-Z\u2E80-\u9FFF_-]{1,10}$/;
        reg_userAge = /^(([0-9]|[1-9][1-9]|1[0-7][0-9])(\\.[0-9]+)?|180)$/

        if (userName.length > 10) {
            alert("用户名字符长度不能大于10！");
            return false;
        }

        if (!reg_userName.test(userName)) {
            alert("用户名只能包含中文、英文字符、数字、-和_");
            return false;
        }

        if(!reg_userAge.test(userAge)){
            alert("年龄不正确！");
            return false;
        }
    })
});