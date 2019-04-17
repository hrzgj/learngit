package com.chenyu.www.view;

import com.chenyu.www.po.User;
import com.chenyu.www.service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RoomAndUserServlet")
public class RoomAndUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomService roomService=new RoomService();
        int i= Integer.parseInt(request.getParameter("i"));
        User user= (User) request.getSession().getAttribute("user");
        roomService.appointRoom(user,i,response);
        response.sendRedirect("appointSuccess.jsp");

    }
}
