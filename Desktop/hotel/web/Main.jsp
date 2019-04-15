<%@ page import="com.chenyu.www.po.User" %><%--
  Created by IntelliJ IDEA.
  User: 86323
  Date: 2019/4/6
  Time: 18:26
  酒店的主界面，可进行一系列的操作
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%User user= (User) session.getAttribute("user");%>
<html>
<head>
    <title>酒店主界面</title>
</head>
<body style="background:url(image/timg.jpg) ; ">
<link rel="stylesheet" type="text/css" href="css/Room.css" />
<link rel="stylesheet" type="text/css" href="css/Main.css" />
<div class="main" >
    <tr><a href="Login.jsp">注销用户登录</a> </tr>
    <div id="main">
        <br>
        <div ><span class="down">用户管理</span></div>
        <ul>
            <li></li><tr><a href="Print.jsp">
            <%
                if(user.getIdentity().equals("管理员"))
                {   %>
            查看所有用户信息<%}%>
            <%
                if(user.getIdentity().equals("普通用户"))
                {
            %>
            修改自己信息
            <%}%>
        </a></tr>
            <li></li><tr><a href="Update.jsp">修改其它用户信息</a> </tr>
            <li ></li><tr><a href="UpdateAdmin.jsp" >改变用户权限</a></tr>
        </ul>
    </div>
    <br>
    <br><br>
    <div class="room">房间管理<span class="down"></span></div>
    <ul>
        <a href="FindRoom.jsp">浏览，预定房间</a>
    </ul>
    <ul>
        <li>
            <% if(user.getIdentity().equals("管理员"))
            {
            %>
                <a href="AddRoom.jsp">增加房间</a>
            <%}%>
        </li>

    </ul>

</div>
</body>
</html>
