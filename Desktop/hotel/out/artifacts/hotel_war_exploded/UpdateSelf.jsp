<%@ page import="com.chenyu.www.po.User" %>
<%--
  Created by IntelliJ IDEA.
  User: 86323
  Date: 2019/4/7
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
   User  user = (User) session.getAttribute("user");
%>
<html>
<head>
    <title>修改自己信息</title>
</head>
<body style="background:url(image/timg.jpg);">
<tr><a href="Main.jsp" >点击返回主菜单</a> </tr>
<div style="display:block;text-align:center;margin: 202px;">

    <form action="UpdateSelfServlet" method="get">
    <table align="center">
        <p></p><span style="color: green">账号：</span><%=user.getUserAccount()%>
        <p></p><span style="color: green">昵称：</span><input type="text" name="user_name" value=<%=user.getUserName()%>>
        <font color="red">${requestScope.username}</font>
        <h5 style="color: red;">昵称：32位内的字符</h5>
        <p></p><span style="color: green">手机号：</span><input type="text" name="user_phone" value=<%=user.getUserPhone()%> >
        <font color="red">${requestScope.userphone}</font>
        <h5 style="color: red;">手机号为11个数字</h5>
        <p></p><span style="color: green">身份证：</span><input type="text" name="user_idNumber" value=<%=user.getUserIdNumber()%>>
        <font color="red">${requestScope.useridNumber}</font>
        <h5 style="color: red;">身份证为18位数字</h5>
        <p></p><span style="color: green">密码：</span><input type="text" name="user_password" value=<%=user.getUserPassword()%>>
        <font color="red">${requestScope.userpassword}</font>
        <p>
            <button class="button" type="submit">点击修改</button>
        </p>
    </table>
    </form>
</div>
</body>
</html>
