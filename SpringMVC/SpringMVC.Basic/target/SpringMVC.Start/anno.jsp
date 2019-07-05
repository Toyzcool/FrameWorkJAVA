<%--
  Created by IntelliJ IDEA.
  User: toyz
  Date: 2019-07-05
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Annotation</title>
</head>
<body>
    <%--常用注解--%>
    <h2>常用注解</h2>

    <%--1.RequestParam注解--%>
    <h3>1.RequestParam</h3>
    <a href="anno/testRequestParam?name=吴彦祖">RequestParam</a>

    <%--2.RequestBody注解--%>
    <h3>2.RequestBody</h3>
    <form action="anno/testRequestBody" method="post">
        真实姓名：<input type="text" name="uname"><br>
        年龄：<input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>

    <%--3.PathVariable注解,使用了Restful风格--%>
    <h3>3.PathVariable，使用了Restful风格</h3>
    <a href="anno/testPathVariable/10">PathVariable</a>

    <%--4.RequestHeader--%>
    <h3>4.RequestHeader</h3>
    <a href="anno/testRequestHeader">RequestHeader</a>

    <%--5.CookieValue--%>
    <h3>5.CookieValue</h3>
    <a href="anno/testCookieValue">CookieValue</a>

    <%--6.ModelAttribute--%>
    <h3>6.ModelAttribute</h3>
    <form action="anno/testModelAttribute" method="post">
        真实姓名：<input type="text" name="uname"><br>
        年龄：<input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>

    <%--7.SessionAttribute--%>
    <h3>7.SessionAttribute</h3>
    <a href="anno/setSessionAttribute">setSessionAttribute</a>
    <a href="anno/getSessionAttribute">getSessionAttribute</a>
    <a href="anno/delSessionAttribute">delSessionAttribute</a>

</body>
</html>
