<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>尚硅谷会员注册页面</title>
    <!--静态包含base标签和css样式-->
    <%@include file="/pages/common/head.jsp"%>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
    <script src="static/js/jquery-1.7.2.js"></script>
	<script>
		//1.验证用户名、密码、邮箱、验证码是否合法（正则表达式）
		//2.不合法提示错误信息（。errorMsg）。合法提交
		$(function () {
			$("#sub_btn").click(function () {
                //获取用户输入的用户名、密码、邮箱、验证码
                var username = $("#username").val();
                var password = $("#password").val();
                var repwd = $("#repwd").val();
                var email = $("#email").val();
                var code = $("#code").val();
                //用于验证的正则表达式
                var usernamePat = /^\w{5,12}$/;
                var passwordPat = /^\w{5,12}$/;
                var emailPat = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                //开始验证
                if (!usernamePat.test(username)){
                    $(".errorMsg").text("用户名输入不合法！");
                    return false;
                }
                if (!passwordPat.test(password)){
                    $(".errorMsg").text("密码输入不合法！");
                    return false;
                }
                if (password != repwd){
                    $(".errorMsg").text("两次密码不一致！");
                    return false;
                }
                if (!emailPat.test(email)){
                    $(".errorMsg").text("邮箱输入不合法！");
                    return false;
                }
                code = $.trim(code);
                if (code == null || code == ""){
                    $(".errorMsg").text("验证码不能为空！");
                    return false;
                }
			});
			//单击事件换验证码
            $("#code_img").click(function () {
                this.src = "${basePath}kaptcha.jpg?d=" + new Date();
            });
		});
	</script>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">
            欢迎注册
        </span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册尚硅谷会员</h1>
                    <span class="errorMsg">
                        ${requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="register"/>
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1"
                               name="username" id="username"
                                value="${requestScope.username}"/>
                        <br/>
                        <br/>
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1"
                               name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1"
                               name="email" id="email"
                                value="${requestScope.email}"/>
                        <br/>
                        <br/>
                        <label>验证码：</label>
                        <input class="itxt" type="text" style="width: 150px;" name="code" id="code"/>
                        <img alt="" id="code_img" src="kaptcha.jpg" style="float: right; margin-right: 40px; width: 90px; height: 40px">
                        <br/>
                        <br/>
                        <input type="submit" value="注册" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<!--静态包含页脚-->
<%@include file="/pages/common/foot.jsp"%>>
</body>
</html>