<%@ page import="com.chenyu.www.po.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.chenyu.www.po.Room" %>

<%--
  Created by IntelliJ IDEA.
  User: 86323
  Date: 2019/4/15
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int intPageSize=10; //每页显示的房间数
    int intPageCount;   //总页码
    String strPage;   //用户请求的页码
    int intPage;       //待显示的页码
    int currPage;      //起始记录索引

%>
<%
    User user= (User) session.getAttribute("user");
    ArrayList<Room> rooms= (ArrayList<Room>) session.getAttribute("rooms");
    Room room=new Room();
    strPage=request.getParameter("pagenumber");
    if(strPage == null)
        intPage=1;
    else
    {
        intPage=Integer.parseInt(strPage);
        if(intPage<1)
            intPage=1;
    }
    intPageCount=(rooms.size()+intPageSize-1)/intPageSize;
    if(intPage>intPageCount)
        intPage = intPageCount;
    currPage=intPage*intPageSize-intPageSize;
%>
<html>
<head>
    <title>浏览预定房间</title>
</head>
<body  style="background:url(image/timg.jpg) ;">
<a href="Main.jsp">点击返回主菜单</a>
<link rel="stylesheet" type="text/css" href="css/FindRoom.css" />
<table>
    <caption>房间信息</caption>
    <tr>
        <td>房间编号</td>
        <% if(user.getIdentity().equals("管理员")){%>
        <td>房间类型(点击即可修改房间信息)</td>
        <%}%>
        <% if(user.getIdentity().equals("普通用户")){%>
        <td>房间类型</td>
        <%}%>

        <td>房间价格</td>
        <td>房间是否含早餐</td>
        <td>房间面积</td>
        <td>房间楼层</td>
        <td>房间情况</td>

    </tr>
    <% for(int i=currPage;i<intPage*intPageSize&&i<rooms.size();i++){  %>
    <tr>
        <%
            room=rooms.get(i);
        %>
        <td align="center" class = "td"><%=i+1 %> </td>
        <td align="center" class = "td">
            <%-->判断用户身份来确定是否可以修改房间信息<--%>
            <%if(user.getIdentity().equals("普通用户")){%>
            <%if(room.getRoomType()==1){%>单人房<%}%>
            <%if(room.getRoomType()==2){%>双人房<%}%>
            <%if(room.getRoomType()==3){%>特价房<%}%>
            <%if(room.getRoomType()==4){%>总统房<%}%>
            <%if(room.getRoomType()==5){%>商务房<%}%>
            <%}%>
            <%if(user.getIdentity().equals("管理员")){%>
            <a href="UpdateRoom.jsp?i=<%=i%>">
                <%if(room.getRoomType()==1){%>单人房<%}%>
                <%if(room.getRoomType()==2){%>双人房<%}%>
                <%if(room.getRoomType()==3){%>特价房<%}%>
                <%if(room.getRoomType()==4){%>总统房<%}%>
                <%if(room.getRoomType()==5){%>商务房<%}%>
            </a>
            <%}%>
        </td>
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
            <%-->如果房间未被预定点击即可预定<--%>
            <%if(room.getRoomUser()==0) {%>
            <a href="RoomAndUserServlet?i=<%=i%>" class="ac">未预定(点击即可预定)</a> <%}%>
            <%-->如果房间已被预定，如果用户是管理员即可点击查看预定用户信息，否则只能提示已预订<--%>
            <% if(room.getRoomUser()!=0&&user.getIdentity().equals("管理员")) { %>
            <a href="FindRoomUserServlet?i=<%=i%>" class="ac">已预定(点击查看预定人信息)</a> <%}%>
            <% if(user.getIdentity().equals("普通用户")&&room.getRoomUser()!=0){%>
            已预订<%}%>
        </td>
<%}%>
    </tr>
    <table align="center">
       <tr>第<%=intPage%>页(共<%=intPageCount%>页)</tr>
        <a href="FindRoom.jsp?pagenumber<%=1%>" class="ah">首页</a>
    <a href="FindRoom.jsp?pagenumber=<%=intPage-1%>" class="ah">上一页</a>
    <a href="FindRoom.jsp?pagenumber=<%=intPage+1%>" class="ah">下一页</a>
    <a href="FindRoom.jsp?pagenumber=<%=intPageCount%>" class="ah">尾页</a>
    </table>



</table>




</body>
</html>
