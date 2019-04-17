package com.chenyu.www.view;

import com.chenyu.www.po.User;
import com.chenyu.www.service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FindRoomUserServlet")
public class FindRoomUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int i= Integer.parseInt(request.getParameter("i"));
        RoomService roomService=new RoomService();
        User user=roomService.findRoomUser(i);
        request.getSession().setAttribute("roomUser",user);
        response.sendRedirect("RoomUser.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
