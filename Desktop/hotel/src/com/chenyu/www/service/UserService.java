package com.chenyu.www.service;

import com.chenyu.www.dao.impl.UserDao;
import com.chenyu.www.dao.impl.UserDaoImpl;
import com.chenyu.www.po.Room;
import com.chenyu.www.po.User;
import com.chenyu.www.util.AppMD5Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserService {

    //登录服务
    public void login(String userAccount, String userPassword,HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        UserDao u = new UserDaoImpl();
        User user =u.login(userAccount,userPassword);
        if(user!=null)
        {
            request.getSession().setAttribute("user",user);
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request,response);
        }
        else
        {
            response.sendRedirect("/hotel_war_exploded/LoginFail.jsp");
        }

    }

    //判断用户账户密码是否正确
    public Boolean isRight(String user)
    {
        if (user.length() > 5 && user.length() < 21
                && user.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$")) {
            return true;
        } else {
            return false;
        }
    }

    //判断用户手机号是否11位
    public  Boolean isPhoneRight(String phone)
    {
         return phone.matches("[0-9]{11}");

    }

    //判断用户身份证是否为18位
    public Boolean isUserIdNumberRight(String userIdNumber)
    {
       return userIdNumber.matches("[0-9]{18}");
    }


    //注册的服务
    public void Register(String userName, String usePassword, String usePhone, String userAccount,String userIdNumber, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isRight(userAccount))
        {
            request.setAttribute("account","账户格式错误");
            request.getRequestDispatcher("Register.jsp").forward(request,response);
            return;
        }
       if(!isRight(usePassword))
        {
            request.setAttribute("password","密码格式错误");
            request.getRequestDispatcher("Register.jsp").forward(request,response);
        }
        if(userName.length()<1||userName.length()>32)
        {
            request.setAttribute("name","昵称格式错误");
            request.getRequestDispatcher("Register.jsp").forward(request,response);
            return;
        }
        if(!isPhoneRight(usePhone))
        {
            request.setAttribute("phone","手机格式错误");
            request.getRequestDispatcher("Register.jsp").forward(request,response);
            return;
        }
        if(!isUserIdNumberRight(userIdNumber))
        {
            request.setAttribute("idNumber","身份证格式错误");
            request.getRequestDispatcher("Register.jsp").forward(request,response);
            return;
        }
        UserDao u=new UserDaoImpl();
        if(u.findAccount(userAccount))
        {
            request.setAttribute("account","该账户已存在");
            request.getRequestDispatcher("Register.jsp").forward(request,response);
            return;
        }
        usePassword= AppMD5Util.getMD5(usePassword);
        User user =new User();
        user.setIdentity("普通用户");
        user.setUserIdNumber(userIdNumber);
        user.setUserPhone(usePhone);
        user.setUserAccount(userAccount);
        user.setUserPassword(usePassword);
        user.setUserName(userName);
        request.getSession().setAttribute("user",user);
        if(u.register(userName,usePassword,usePhone,userAccount,userIdNumber)) {
            response.sendRedirect("http://localhost:8080/hotel_war_exploded/RegisterSuccess.jsp");
        }
    }

    //更新一个用户的服务
    public  void Update(User user,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!isRight(user.getUserPassword()))
        {
            request.setAttribute("userpassword","密码格式错误");
            request.getRequestDispatcher("UpdateSelf.jsp").forward(request,response);
        }
        if(user.getUserName().length()<1||user.getUserName().length()>32)
        {
            request.setAttribute("username","昵称格式错误");
            request.getRequestDispatcher("UpdateSelf.jsp").forward(request,response);
            return;
        }
        if(!isPhoneRight(user.getUserPhone()))
        {
            request.setAttribute("userphone","手机号码格式错误");
            request.getRequestDispatcher("UpdateSelf.jsp").forward(request,response);
            return;
        }
        if(!isUserIdNumberRight(user.getUserIdNumber()))
        {
            request.setAttribute("useridNumber","身份证格式错误");
            request.getRequestDispatcher("UpdateSelf.jsp").forward(request,response);
            return;
        }
        //密码加密
        user.setUserPassword(AppMD5Util.getMD5(user.getUserPassword()));
        UserDao u=new UserDaoImpl();
            if(u.update(user))
            {
                request.getSession().setAttribute("user",user);
                request.getRequestDispatcher("UpdateSelfSuccess.jsp").forward(request,response);
            }
    }

    //更新一个用户但不包括密码的服务
    public  void  UpdateWithoutPassword(User user,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(user.getUserName().length()<1||user.getUserName().length()>32)
        {
            request.setAttribute("thisUserName","昵称格式错误");
            request.getRequestDispatcher("UpdateAll.jsp").forward(request,response);
            return;
        }
        if(!isPhoneRight(user.getUserPhone()))
        {
            request.setAttribute("thisUserPhone","手机号码格式错误");
            request.getRequestDispatcher("UpdateAll.jsp").forward(request,response);
            return;
        }
        if(!isUserIdNumberRight(user.getUserIdNumber()))
        {
            request.setAttribute("thisUserIdNumber","身份证格式错误");
            request.getRequestDispatcher("UpdateAll.jsp").forward(request,response);
            return;
        }
        UserDao u=new UserDaoImpl();
        if(u.updateWithoutPassword(user))
        {
            response.sendRedirect("UpdateSelfSuccess.jsp");
        }

    }

    //更新一个用户权限的服务
    public  void  UpdateAdmin(String userAccount,HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        UserDao userDao=new UserDaoImpl();
        int identity=userDao.findIdentity(userAccount);
        if(identity==1)
            identity=0;
        else  if(identity==0)
            identity=1;
        else
            return;
        if(userDao.updateAdmin(userAccount,identity))
        {
            response.sendRedirect("UpdateSelfSuccess.jsp");
        }



    }


}