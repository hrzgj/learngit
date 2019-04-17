<%--
  Created by IntelliJ IDEA.
  User: 86323
  Date: 2019/4/16
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>预约成功</title>
</head>
<body>
<center>预约房间成功，稍后返回房间界面</center>
<%
    response.setHeader("refresh","2;url=/hotel_war_exploded/FindRoom.jsp");
%>
</body>
</html>
