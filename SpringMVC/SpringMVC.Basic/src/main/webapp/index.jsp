<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<%--RequestMapping属性--%>
<%--value、path属性，效果一样--%>
<h2>RequestMapping属性</h2>
<h3>value、path属性，效果一样</h3>
<h4>设计二级value = "/user/testValue",value = "/order/testValue"，用于划分模块</h4>
<a href="user/testValue">testValue...user</a><br>
<a href="order/testValue">testValue...order</a>

<%--method属性--%>
<h3>method属性，预期是请求失败，因为需要是post方法</h3>
<a href="testMethod">testMethod</a>

<%--params属性--%>
<h3>params属性,带username属性,而且值必须为Toyz</h3>
<a href="testParams?username=Toyz">testParams...username</a>

<%--header属性--%>
<h3>header属性</h3>
<a href="testHeader">testHeader...accept</a>
</body>
</html>