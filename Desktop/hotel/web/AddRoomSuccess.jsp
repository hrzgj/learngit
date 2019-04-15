<%--
  Created by IntelliJ IDEA.
  User: 86323
  Date: 2019/4/11
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加房间</title>
</head>
<body>
<center>增加房间成功，稍后进入主界面</center>
<%
    response.setHeader("refresh","3;url=/hotel_war_exploded/Main.jsp");
%>
</body>
</html>
