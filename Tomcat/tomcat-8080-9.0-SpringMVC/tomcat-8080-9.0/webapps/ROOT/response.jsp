<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Response</title>
    <script src="resources/js/jquery/jquery-3.4.1.min.js"></script>
    <script src="resources/js/bootstrap/bootstrap.min.js"></script>
    <link href="resources/css/bootstrap/bootstrap.min.css" rel="stylesheet">

    <script>
    <%--发送Ajax请求--%>
        $(function () {
            $("#btn").click(function () {
            //    编写json格式数据
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset:UTF-8",
                    data:'{"username":"toyzAjax","password":"321","age":40}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                    //    服务器响应json数据，进行解析
                        alert(data);
                        alert(data.username+data.password+data.age);
                    }
                });
            });
        });
    </script>

</head>
<body>
    <%-- 1. Response --%>
    <h3>1. Response</h3>
    <a href="user/testString" >获取用户名和密码</a><br>
    <a href="user/testVoid" >测试响应void类型</a><br>
    <a href="user/testModelAndView">测试响应testModelAndView类型</a><br>
    <a href="user/testForwardOrRedirect">使用关键字进行转发和重定向</a><br>

    <%-- 2.ResponseBody --%>
    <h3>2. ResponseBody</h3>
    <button id="btn" class="btn btn-success">Ajax异步请求</button>

</body>
</html>
