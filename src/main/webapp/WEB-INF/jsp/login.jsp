<%--
  Created by IntelliJ IDEA.
  User: Zzzz
  Date: 2017/12/11
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>register</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
    <body>
    <h2>登录</h2><br>
    <input type="text" name="phonenumber" style="height: 30px;width: 100px" placeholder="手机号"><br>
    <input type="password" name="password" style="height: 30px;width: 100px" placeholder="密码"><br>
    <input type="button" onclick="dologin()" name="submit" value="登录" style="height: 30px;width: 100px"><br>
    <form action="/user/gotoRegister" method="get">
        <input type="submit" name="submit" value="注册" style="height: 30px;width: 100px">
    </form>
    </body>
</html>
<script type="text/javascript">
    function dologin() {
        var phonenumber = document.getElementsByTagName("input")[0].value;
        var password = document.getElementsByTagName("input")[1].value;
        $.ajax({
            type : "post",
            url : "/user/login",
            dataType:"json",
            data : {
                "phonenumber" : phonenumber,
                "password" : password
            },
            success : function(data){
                alert(data.message);
            }
        });
    }
</script>