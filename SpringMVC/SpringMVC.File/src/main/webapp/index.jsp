<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="resources/js/jquery/jquery-3.4.1.min.js"></script>
<script src="resources/js/bootstrap/bootstrap.min.js"></script>
<link href="resources/css/bootstrap/bootstrap.min.css" rel="stylesheet">
<head>
    <title>Index</title>
</head>
<body>
    <%--1.传统方式上传文件--%>
    <h3>1.传统方式上传文件</h3>
    <form action="/file/fileUpload1" method="post" enctype="multipart/form-data">
        文件上传：<input type="file" name="upload"/>
        <input type="submit" value="上传"/>
    </form>

    <%--2.SpringMVC方式上传文件--%>
    <h3>2.SpringMVC方式上传文件</h3>
    <form action="/file/fileUpload2" method="post" enctype="multipart/form-data">
        文件上传：<input type="file" name="upload"/>
        <input type="submit" value="上传"/>
    </form>

    <%--3.跨服务器上传文件--%>
    <h3>3.跨服务器上传文件</h3>
    <form action="/file/fileUpload3" method="post" enctype="multipart/form-data">
        文件上传：<input type="file" name="upload"/>
        <input type="submit" value="上传"/>
    </form>
    
</body>
</html>
