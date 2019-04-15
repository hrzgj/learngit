<%@ page import="com.chenyu.www.po.User" %>
<%@ page import="com.chenyu.www.dao.impl.UserDao" %>
<%@ page import="com.chenyu.www.dao.impl.UserDaoImpl" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 86323
  Date: 2019/4/7
  Time: 15:55
  作用：管理员修改用户的界面
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User user = (User) session.getAttribute("user");%>
<% if (user.getIdentity().equals("普通用户"))
{ %>
<jsp:forward page="identityError.jsp"></jsp:forward>
<% }%>
<%
    UserDao u=new UserDaoImpl();
    ArrayList<User> list=u.getMaterialsList();
    %>
<html>
<head>
    <title>修改用户信息</title>
</head>
<body style="background:url(image/timg.jpg) ;">
<tr><a href="Main.jsp">点击返回主菜单</a> </tr>
<table width="320" height="20" border="1" align="center">
    <caption class = "cap1">以下为可修改用户信息，点击即可修改</caption>
    <br>
    <tr>
        <th width="60" class = "th">用户账户</th>

    </tr>
    <% for(User user1:list){  %>
    <tr>

        <td align="center" class = "td">
        <a href="UpdateStop.jsp?userAccount=<%=user1.getUserAccount()%>">
            <%out.print(user1.getUserAccount());%>
        </a>
    </tr>
    <% }%>
</table>
</body>
</html>
