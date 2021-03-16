<%@ page language="java" contentType="text/html; charset=UTF-8; "
         pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>契约锁</title>
</head>
<body>
<h1>文件详情：</h1>
<h2>UUID:   ${message.UUID}</h2>
<h2>文件大小:  ${message.fileCount}</h2>
<h2>文件类型:  ${message.fileType}</h2>
<h2>原文件名:  ${message.oldName}</h2>
<h2>创建时间:  ${message.buileTime}</h2>
<h2>文件保存目录:  ${message.filePath}</h2>
</body>
</html>
