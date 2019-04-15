<%@ page import="com.chenyu.www.po.User" %>
<%@ page import="com.chenyu.www.dao.impl.UserDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.chenyu.www.dao.impl.UserDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: 86323
  Date: 2019/4/15
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String userAccount= request.getParameter("userAccount");
    UserDao u=new UserDaoImpl();
    ArrayList<User> users=u.getMaterialsList();
    for(User thisUser:users)
    {
        if(thisUser.getUserAccount().equals(userAccount))
        {
            session.setAttribute("theUser",thisUser);
            break;
        }
    }
    response.setHeader("refresh","0;url=/hotel_war_exploded/UpdateAll.jsp");
%>
</body>
</html>
