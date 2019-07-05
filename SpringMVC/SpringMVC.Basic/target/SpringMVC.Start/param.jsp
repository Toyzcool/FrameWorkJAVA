<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Param</title>
</head>
<body>
    <h3>1.测试参数绑定传递</h3>
    <a href="param/testParam?username=toyz&&password=123">测试参数绑定传递</a>

<%--    <h3>2.测试参数绑定把数据封装到JavaBean中</h3>--%>
<%--    <form action="param/savaAccount" method="post">--%>
<%--        姓名：<input type="text" name="username"><br>--%>
<%--        密码：<input type="text" name="password"><br>--%>
<%--        金额：<input type="text" name="money"><br>--%>
<%--        真实姓名：<input type="text" name="user.uname"><br>--%>
<%--        年龄：<input type="text" name="user.age"><br>--%>
<%--        <input type="submit" value="提交">--%>
<%--    </form>--%>

        <h3>3.测试参数绑定把数据封装到Account中,类中存在list和map集合</h3>
        <form action="param/savaAccount" method="post">
            姓名：<input type="text" name="username"><br>
            密码：<input type="text" name="password"><br>
            金额：<input type="text" name="money"><br>
            <%--List集合属性注入--%>
            真实姓名：<input type="text" name="list[0].uname"><br>
            年龄：<input type="text" name="list[0].age"><br>
            <%--Map集合属性注入--%>
            真实姓名：<input type="text" name="map['one'].uname"><br>
            年龄：<input type="text" name="map['one'].age"><br>
            <input type="submit" value="提交">
        </form>

    <h3>4.日期数据的格式转化</h3>
    <form action="param/saveUser" method="post">
        真实姓名：<input type="text" name="uname"><br>
        年龄：<input type="text" name="age"><br>
        生日：<input type="text" name="date"><br>
        <input type="submit" value="提交">
    </form>

    <h3>5.获取ServletAPI</h3>
    <a href="param/getServletAPI">获取ServletAPI</a>

</body>
</html>
