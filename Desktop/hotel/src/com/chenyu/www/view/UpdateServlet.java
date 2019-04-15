package com.chenyu.www.view;


import com.chenyu.www.po.User;
import com.chenyu.www.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("theUser");
        user.setUserName(request.getParameter("user_Name"));
        user.setUserPhone(request.getParameter("user_Phone"));
        user.setUserIdNumber(request.getParameter("user_IdNumber"));
        UserService u=new UserService();
        u.UpdateWithoutPassword(user,request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

}
