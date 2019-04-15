package com.chenyu.www.view;

import com.chenyu.www.po.Room;
import com.chenyu.www.service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "FindRoomServlet")
public class FindRoomServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        RoomService roomService=new RoomService();
        ArrayList<Room> rooms=roomService.findRoom();
        request.getSession().setAttribute("roomList",rooms);
        response.sendRedirect("/hotel_war_exploded/FindRoom.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
