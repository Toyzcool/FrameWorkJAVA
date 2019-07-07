<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="resources/js/jquery/jquery-3.4.1.min.js"></script>
<script src="resources/js/bootstrap/bootstrap.min.js"></script>
<link href="resources/css/bootstrap/bootstrap.min.css" rel="stylesheet">
<head>
    <title>Index</title>
</head>
<body>
    <%--传统方式上传文件--%>
    <h3>传统方式上传文件</h3>
        <form action="/user/fileUpload1" method="post" enctype="multipart/form-data">
            文件上传：<input type="file" name="Upload"/>
            <input type="submit" value="上传"/>
        </form>

    <%--SpringMVC方式上传文件--%>
    <h3>SpringMVC方式上传文件</h3>
    <form action="/user/fileUpload2" method="post" enctype="multipart/form-data">
        文件上传：<input type="file" name="springmvcUpload"/>
        <input type="submit" value="上传"/>
    </form>
</body>
</html>
