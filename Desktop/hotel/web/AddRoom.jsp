<%--
  Created by IntelliJ IDEA.
  User: 86323
  Date: 2019/4/11
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<html>
<head>
    <title>增加房间</title>
</head>
<body style="background:url(image/timg.jpg);">
<tr><a href="Main.jsp">点击返回主菜单</a> </tr>
<link rel="stylesheet" type="text/css" href="css/AddRoom.css" />
<div style="display:block;text-align:center;margin: 202px;" id="login">
    <table align="center">
        <h1 style="color: red;">房间增加</h1>
        <form  action="AddRoomServlet" method="post">
            <p>
                <span style="color: green">房间面积大小</span> <input type="text" name="room_area">
                <font color="red">
                    ${requestScope.area}</font>
            </p>
            <h5 style="color: red;">
                房间面积大于0小于1000
            </h5>
            <p>
                <span style="color: green">房间类型(价格将根据房间类型决定)</span>
                <select name="room_type">
                    <option value="1">单人房</option>
                    <option value="2">双人房</option>
                    <option value="3">特价房</option>
                    <option value="4">总统房</option>
                    <option value="5">商务房</option>
                </select>
            </p>
            <p>
                <span style="color: green">房间是否配早餐</span>
                <select name="room_breakfast">
                    <option value="1">是</option>
                    <option value="0">否</option>
                </select>
            </p>
            <p>
                <span style="color: green;margin: 0pc;">房间市场价格</span>
                <select name="room_price">
                    <option value="1">正常价</option>
                    <option value="2">较高价</option>
                    <option value="0">较低价</option>
                </select>
            </p>
            <p>
                <span style="color: green">房间楼数</span> <input type="text" name="room_high">
                <font color="red">
                    ${requestScope.high}</font>
            </p>
            <h5 style="color: red;">
                房间楼数大于0小于50
            </h5>
                <button  type="submit">点击增加</button>
            </p>
        </form>
    </table>
</div>
</body>
</html>
