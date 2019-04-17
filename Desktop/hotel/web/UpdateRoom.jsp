
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.chenyu.www.po.Room" %>
<%@ page import="com.chenyu.www.dao.impl.RoomDao" %>
<%@ page import="com.chenyu.www.dao.impl.RoomDaoImpl" %>
<%@ page import="com.chenyu.www.util.Constant" %><%--
  Created by IntelliJ IDEA.
  User: 86323
  Date: 2019/4/17
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  int i= Integer.parseInt(request.getParameter("i"));
    RoomDao roomDac =new RoomDaoImpl();
    ArrayList<Room> rooms=roomDac.findAllRoom();
    Room room=rooms.get(i);
    String roomType = null;
    String roomBreakfast=null;
    if(room.getRoomType()==1)
        roomType= Constant.ROOMTYPE1;
    if(room.getRoomType()==2)
        roomType=Constant.ROOMTYPE2;
    if(room.getRoomType()==3)
        roomType=Constant.ROOMTYPE3;
    if(room.getRoomType()==4)
        roomType=Constant.ROOMTYPE4;
    if(room.getRoomType()==5)
        roomType=Constant.ROOMTYPE5;
    if(room.getRoomBreakfast()==1)
        roomBreakfast=Constant.ROOMBREAKFAST1;
    if(room.getRoomBreakfast()==0)
        roomBreakfast=Constant.ROOMBREAKFAST2;
%>
<html>
<head>
    <title>Document</title>
</head>
<body style="background:url(image/timg.jpg) ;">
<link rel="stylesheet" type="text/css" href="css/UpdateRoom.css" />
<tr><a href="FindRoom.jsp">点击返回上个界面</a> </tr>
<div id="login">
<form name="form2" action="UpdateRoomServlet?i=<%=i%>" method="post" onsubmit="return check()">
    <table>
        <p>
        <span>房间类型:<%=roomType%></span>
        <select name="roomType">
            <option value="1">单人房</option>
            <option value="2">双人房</option>
            <option value="3">特价房</option>
            <option value="4">总统房</option>
            <option value="5">商务房</option>
        </select>
        </p>
        <p>
        <span>房间价格</span>
        <input type="text" name="roomPrice" value="<%=room.getRoomPrice()%>"></input>
        </p>
        <p>
        <span>房间早餐：<%=roomBreakfast%></span>
        <select name="roomBreakfast">
            <option value="1">是</option>
            <option value="0">否</option>
        </select>
        </p>
        <p>
        <span>房间面积</span>
        <input type="text" name="roomArea" value="<%=room.getRoomArea()%>"></input>
        </p>
        <p>
        <span>房间楼数</span>
        <input type="text" name="roomHigh" value="<%=room.getRoomHigh()%>"></input>
        </p>
        <button class="button" type="submit">点击修改</button>
    </table>
</form>
</div>
</body>
<script type="text/javascript" src="js/Room.js"></script>
</html>
