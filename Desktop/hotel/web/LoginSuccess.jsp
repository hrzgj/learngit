<%@ page import="com.chenyu.www.po.User" %><%--
  Created by IntelliJ IDEA.
  User: 86323
  Date: 2019/4/7
  Time: 10:04
  登录成功的提示
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
<%
    User user= (User) session.getAttribute("user");

%>

<center>恭喜<%out.print(user.getUserName());%>登录成功，您是<%out.print(user.getIdentity());%>稍后进入主界面</center>

<%
    response.setHeader("refresh","3;url=/hotel_war_exploded/Main.jsp");
%>

</body>
</html>
