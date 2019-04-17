package com.chenyu.www.view;

import com.chenyu.www.po.Room;
import com.chenyu.www.service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddRoomServlet")
public class AddRoomServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Room room=new Room();
        room.setRoomArea(Double.parseDouble(request.getParameter("room_area")));
        room.setRoomBreakfast(Integer.parseInt(request.getParameter("room_breakfast")));
        room.setRoomHigh(Integer.parseInt(request.getParameter("room_high")));
        room.setRoomPriceAndRoomType(request.getParameter("room_price"));
        room.setRoomType(Integer.parseInt(request.getParameter("room_type")));
        RoomService roomService=new RoomService();
        roomService.addRoom(room,request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
