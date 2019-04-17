<%@ page import="com.chenyu.www.po.User" %><%--
  Created by IntelliJ IDEA.
  User: 86323
  Date: 2019/4/16
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user= (User) session.getAttribute("roomUser");
%>
<html>
<head>
    <title>预定房间的用户</title>
</head>
<body style="background:url(image/timg.jpg) ;">
<table width="800" height="200" border="1" align="center">
    <caption class = "cap1">用户信息</caption>
    <br>
    <tr>
        <th width="92" class = "th">用户名</th>
        <th width="92" class = "th">用户账户</th>
        <th width="150" class = "th">用户手机</th>
        <th width="150" class = "th">身份</th>
        <th width="200" class = "th">用户身份证</th>
    </tr>


    <tr>
        <td align="center" class = "td"><%=user.getUserName() %> </td>
        <td align="center" class = "td"><%=user.getUserAccount()%></td>
        <td align="center" class = "td"><%=user.getUserPhone() %> </td>
        <td align="center" class = "td"><%=user.getIdentity() %> </td>
        <td align="center" class = "td"><%=user.getUserIdNumber() %> </td>
    </tr>

    <tr><a href="FindRoom.jsp">点击返回上一页</a> </tr>
</table>
</body>
</html>
