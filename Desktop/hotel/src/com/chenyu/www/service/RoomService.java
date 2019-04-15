package com.chenyu.www.service;

import com.chenyu.www.dao.impl.RoomDao;
import com.chenyu.www.dao.impl.RoomDaoImpl;
import com.chenyu.www.po.Room;
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

    public void addRoom(Room room, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        if(room.getRoomType().equals(Constant.ROOMTYPE1))
        {
            room.setRoomPrice(CreatRandomDouble.randomDouble(100,200));
        }
        else if(room.getRoomType().equals(Constant.ROOMTYPE2))
        {
            room.setRoomPrice(CreatRandomDouble.randomDouble(200,400));
        }
        else if(room.getRoomType().equals(Constant.ROOMTYPE5))
        {
            room.setRoomPrice(CreatRandomDouble.randomDouble(50,120));
        }
        else if(room.getRoomType().equals(Constant.ROOMTYPE3))
        {
            room.setRoomPrice(CreatRandomDouble.randomDouble(800,1600));
        }
        else
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

    public ArrayList<Room> findRoom()
    {
        RoomDao roomDao=new RoomDaoImpl();
        return roomDao.findAllRoom();
    }
}
