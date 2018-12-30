<%--
  Created by IntelliJ IDEA.
  User: Zzzz
  Date: 2017/12/11
  Time: 15:26
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
    <h2>注册</h2><br>
    <input type="text" name="phonenumber" style="height: 30px;width: 100px" placeholder="手机号"><br>
    <input type="password" name="password" style="height: 30px;width: 100px" placeholder="密码"><br>
    <input type="password" name="cpassword" style="height: 30px;width: 100px" placeholder="确认密码"><br>
    <input type="text" name="userName" style="height: 30px;width: 100px" placeholder="用户名"><br>
    <input type="button" onclick="doRegister()" name="submit" value="确定注册" style="height: 30px;width: 100px"><br>
    <form action="/user/gotoLogin" method="get">
        <input type="submit" name="submit" value="登录" style="height: 30px;width: 100px">
    </form>
</body>
</html>
<script type="text/javascript">
    function doRegister() {
        var inputList = document.getElementsByTagName("input");
        if(inputList[1].value != inputList[2].value){
            alert("确认密码与密码不一致");
        }else {
            $.ajax({
                type : "post",
                url : "/user/register",
                dataType:"json",
                data : {
                    "phonenumber" : inputList[0].value,
                    "password" : inputList[1].value,
                    "userName" : inputList[3].value
                },
                success : function(data){
                    alert(data.message);
                }
            });
        }
    }
</script>