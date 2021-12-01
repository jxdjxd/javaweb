$(function () {
    $('input[type="submit"]').click(function () {

        var userName = $("input#userName").val();
        var password = $("input#password").val();

        reg_userName = /^[a-z0-9A-Z\u2E80-\u9FFF_-]{1,10}$/;
        reg_password = /^[a-z0-9A-Z]{6,10}$/;

        if (userName.length > 10) {
            alert("用户名字符长度不能大于10！");
            return false;
        }

        if (!reg_userName.test(userName)) {
            alert("用户名只能包含中文、英文字符、数字、-和_");
            return false;
        }

        if (password.length > 10 || password.length < 6) {
            alert("密码应为6-10个字符");
            return false;
        }

        if (!reg_password.test(password)) {
            alert("密码只能包含英文字符、数字、-和_");
            return false;
        }

    });

    // 当点击验证码图片时就切换验证码
    $("#codeImg").click(changeVarCode);
});

function changeVarCode(){
    var codeImg = $("#codeImg");
    var src = jQuery(codeImg).attr("src");
    jQuery(codeImg).attr("src", chgUrl(src));
    return 0;
}

// 时间戳
// 为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
function chgUrl(url) {
    var timestamp = (new Date()).valueOf();
    url = url.substring(0, 20);
    if ((url.indexOf("&") >= 0)) {
        url = url + "×tamp=" + timestamp;
    } else {
        url = url + "?timestamp=" + timestamp;
    }
    return url;
}