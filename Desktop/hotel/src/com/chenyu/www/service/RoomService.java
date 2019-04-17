package com.chenyu.www.service;

import com.chenyu.www.dao.impl.RoomDao;
import com.chenyu.www.dao.impl.RoomDaoImpl;
import com.chenyu.www.dao.impl.UserDao;
import com.chenyu.www.dao.impl.UserDaoImpl;
import com.chenyu.www.po.Room;
import com.chenyu.www.po.User;
import com.chenyu.www.util.Constant;
import com.chenyu.www.util.CreatRandomDouble;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

public class RoomService {
    //判断房间面积是否正确
    public  Boolean isRoomAreaRight(double RoomArea) {
        BigDecimal RoomAreas = BigDecimal.valueOf(RoomArea);
        if (RoomAreas.compareTo(BigDecimal.ZERO) == -1 || (RoomAreas.compareTo(BigDecimal.valueOf(1000)) == 1)) {
            return false;
        } else {
            return true;
        }
    }

    //判断房间楼层是否正确
    public  Boolean isRoomHighRight(int RoomHigh) {
        if (RoomHigh > 0 && RoomHigh <= 50) {
            return true;
        } else {
            return false;
        }
    }

    //增加房间
    public void addRoom(Room room, HttpServletRequest request, HttpServletResponse response) throws  IOException {
        //判断房间面积的输入是否正确
        if(!isRoomAreaRight(room.getRoomArea()))
        {
            request.setAttribute("area","房间面积输入错误");
            response.sendRedirect("AddRoom.jsp");
        }
        //判断房间楼层的输入是否正确
       if(!isRoomHighRight(room.getRoomHigh()))
        {
            request.setAttribute("high","房间楼层输入错误");
            response.sendRedirect("AddRoom.jsp");
        }
        //以下为根据房间类型自动生成价格
        if(room.getRoomType()==1)
        {
            room.setRoomPrice(CreatRandomDouble.randomDouble(100,200));
        }
        else if(room.getRoomType()==2)
        {
            room.setRoomPrice(CreatRandomDouble.randomDouble(200,400));
        }
        else if(room.getRoomType()==3)
        {
            room.setRoomPrice(CreatRandomDouble.randomDouble(50,120));
        }
        else if(room.getRoomType()==4)
        {
            room.setRoomPrice(CreatRandomDouble.randomDouble(800,1600));
        }
        else if(room.getRoomType()==5)
        {
            room.setRoomPrice(CreatRandomDouble.randomDouble(400,800));
        }
        //以下为根据管理员的定价为该随机数增加倍率
        int rate= Integer.parseInt(room.getRoomPriceAndRoomType());
        if(rate==2)
        {
            room.setRoomPrice(room.getRoomPrice()*2);
        }
        else if(rate==0)
        {
            room.setRoomPrice(room.getRoomPrice()/2);
        }
        RoomDao roomDao=new RoomDaoImpl();
        if(roomDao.addRoom(room)) {
            response.sendRedirect("http://localhost:8080/hotel_war_exploded/AddRoomSuccess.jsp");
        }
    }

    //将数据库表打印出
    public void findRoom(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RoomDao roomDao=new RoomDaoImpl();
        ArrayList<Room> rooms=roomDao.findAllRoom();
        int pageCount=roomDao.findRow();
        request.getSession().setAttribute("rooms",rooms);
        request.getSession().setAttribute("pageCount",pageCount);
        request.getRequestDispatcher("FindRoom.jsp").forward(request,response);

    }

    //将用户id传入房间表的外键
    public Boolean appointRoom(User user,int i,HttpServletResponse response) throws IOException {
        RoomDao roomDao=new RoomDaoImpl();
        if(roomDao.addRoomAndUser(user,i))
        {
            response.sendRedirect("http://localhost:8080/hotel_war_exploded/appointSuccess.jsp");
            return true;
        }
        else
        {
            return false;
        }
    }

    //找出预定房间的用户
    public User findRoomUser(int i)
    {
        RoomDao roomDao=new RoomDaoImpl();
        UserDao userDao=new UserDaoImpl();
        if(roomDao.findRoomUser(i)!=-1)
        {
            return  userDao.findUser(roomDao.findRoomUser(i));
        }
        else {
            return null;
        }
    }

    //修改房间信息
    public Boolean updateRoom(int i,HttpServletRequest request, HttpServletResponse response)
    {
        RoomDao roomDao =new RoomDaoImpl();
        ArrayList<Room> rooms=roomDao.findAllRoom();
        Room room=rooms.get(i);
        room.setRoomBreakfast(Integer.parseInt(request.getParameter("roomBreakfast")));
        room.setRoomHigh(Integer.parseInt(request.getParameter("roomHigh")));
        room.setRoomPrice(Double.parseDouble(request.getParameter("roomPrice")));
        room.setRoomType(Integer.parseInt(request.getParameter("roomType")));
        if(roomDao.updateRoom(room))
        {
            return true;
        }
        else
        {
            return false;
        }



    }

    //取消用户预定房间
    public Boolean cancel(int i)
    {
        RoomDao roomDao=new RoomDaoImpl();
        ArrayList<Room> rooms=roomDao.findAllRoom();
        Room room=rooms.get(i);
        if(roomDao.delereRoomAndUser(room.getRoomID()))
        {
            return true;
        }
        else {
            return false;
        }
    }



}
