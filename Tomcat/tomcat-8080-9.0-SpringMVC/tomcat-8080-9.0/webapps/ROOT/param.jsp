<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Param</title>
</head>
<body>
    <h3>1.测试参数绑定传递</h3>
    <a href="param/testParam?username=toyz&&password=123">测试参数绑定传递</a>

    <h3>2.测试参数绑定把数据封装到JavaBean中</h3>
    <form action="param/savaAccount" method="post">
        姓名：<input type="text" name="username"><br>
        密码：<input type="text" name="password"><br>
        金额：<input type="text" name="money"><br>
        真实姓名：<input type="text" name="user.uname"><br>
        年龄：<input type="text" name="user.age"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
