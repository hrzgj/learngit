<%@ page import="com.chenyu.www.dao.impl.UserDao" %>
<%@ page import="com.chenyu.www.dao.impl.UserDaoImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.chenyu.www.po.User" %><%--
  Created by IntelliJ IDEA.
  User: 86323
  Date: 2019/4/10
  Time: 14:44
  修改用户权限的界面
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user= (User) session.getAttribute("user");
    if(user.getIdentity().equals("普通用户"))
        response.sendRedirect("identityError.jsp");
    UserDao u=new UserDaoImpl();
    ArrayList<User> list =u.getMaterialsList();
%>
<html>
<head>
    <title>修改用户权限</title>
</head>
<body style="background:url(image/timg.jpg) ;">
<tr><a href="Main.jsp">点击返回主菜单</a> </tr>
    <table width="470" height="20" border="1" align="center">
        <caption class = "cap1">以下为可修改用户的权限，点击即可修改</caption>
        <caption class = "cap1" style="color: red">注意！点击修改将会(普通用户变管理员，管理员变普通用户)</caption>
        <br>
        <tr>
            <th width="60" class = "th">用户账户</th>
            <th width="60" class = "th">用户身份</th>
            <th width="20" class = "th">操作</th>
        </tr>

            <% for(User user1:list){  %>
        <tr>
            <td align="center" class = "td"><%=user1.getUserAccount()%> </td>
            <td align="center" class = "td"><%=user1.getIdentity()%> </td>
            <td><a href="UpdateAdminServlet?user_Account=<%=user1.getUserAccount()%>">修改</a></td>
            <% }%>
        </tr>
    </table>


</body>
</html>
