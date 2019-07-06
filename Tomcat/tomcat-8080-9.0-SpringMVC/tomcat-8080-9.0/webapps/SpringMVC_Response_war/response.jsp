<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Response</title>
    <script src="js/jquery.min.js"></script>

    <script>
        $(function () {
            $("#btn").click(function () {
                alert("hello");
            });
        });
    </script>

</head>
<body>
    <%-- 1. Response --%>
    <h2>1. Response</h2>
    <a href="user/testString" >获取用户名和密码</a><br>
    <a href="user/testVoid" >测试响应void类型</a><br>
    <a href="user/testModelAndView">测试响应testModelAndView类型</a><br>
    <a href="user/testForwardOrRedirect">使用关键字进行转发和重定向</a><br>

    <%-- 2.ResponseBody --%>
    <h2>2. ResponseBody</h2>
    <button name="btn">Ajax</button>

</body>
</html>
