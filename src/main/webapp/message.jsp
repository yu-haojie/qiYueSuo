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
    <h2>${message}</h2>
    <form method="get" action="/downLoadServlet">
        输入UUID：<input type="text" name="UUID" />
        <br/><br/>
        <input type="submit" value="下载" />
    </form>
    <br/><br/>
    <br/><br/>
    <form method="get" action="/selectServlet">
        输入UUID：<input type="text" name="UUID" />
        <br/><br/>
        <input type="submit" value="查看文件" />
    </form>
</body>
</html>
