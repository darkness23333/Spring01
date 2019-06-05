<%--
  Created by IntelliJ IDEA.
  User: fenzx
  Date: 2019/6/3
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="/stu/upload" method="post" enctype="multipart/form-data">
    file:<input type="file" name="file"><br>
    desc:<input type="text" name="desc"><br>
    <input type="submit" value="上传">
</form>

</body>
</html>
