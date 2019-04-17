<%--
  Created by IntelliJ IDEA.
  User: 86323
  Date: 2019/4/17
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>取消预约房间成功，稍后返回主界面</center>
<%
    response.setHeader("refresh","2;url=/hotel_war_exploded/Main.jsp");
%>
</body>
</html>
