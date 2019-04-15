<%@ page import="com.chenyu.www.po.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.chenyu.www.po.Room" %>
<%@ page import="com.chenyu.www.service.RoomService" %><%--
  Created by IntelliJ IDEA.
  User: 86323
  Date: 2019/4/15
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user= (User) session.getAttribute("user");
    RoomService roomService=new RoomService();
    ArrayList<Room> rooms=roomService.findRoom();
    int i=1;
%>
<html>
<head>
    <title>浏览预定房间</title>
</head>
<body  style="background:url(image/timg.jpg) ;">
<link rel="stylesheet" type="text/css" href="css/FindRoom.css" />
<table>
    <caption>房间信息</caption>
    <tr>
        <td>房间编号</td>
        <td>房间类型</td>
        <td>房间价格</td>
        <td>房间是否含早餐</td>
        <td>房间面积</td>
        <td>房间楼层</td>
        <td>房间情况</td>
    </tr>
    <% for(Room room:rooms){  %>
    <tr>
        <td align="center" class = "td"><%=i++ %> </td>
        <td align="center" class = "td"><%=room.getRoomType()%> </td>
        <td align="center" class = "td"><%=room.getRoomPrice()%></td>
        <td align="center" class = "td">
            <%if(room.getRoomBreakfast()==1) {%>
            是<%}%>
            <%if(room.getRoomBreakfast()==0) { %>
            否 <%}%>
        </td>
        <td align="center" class = "td"><%=room.getRoomArea() %> </td>
        <td align="center" class = "td"><%=room.getRoomHigh() %> </td>
        <td align="center" class = "td">
            <%if(room.getRoomUser()==0) {%>
            未预定<%}%>
            <% if(room.getRoomUser()!=0) { %>
            已被预定 <%}%>
        </td>
    </tr>
<%}%>
    <tr><a href="Main.jsp">点击返回主菜单</a> </tr>
</table>




</body>
</html>
