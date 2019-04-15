package com.chenyu.www.dao.impl;

import com.chenyu.www.po.Room;
import com.chenyu.www.util.Constant;
import com.chenyu.www.util.DaoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDaoImpl implements RoomDao {
    private  static DaoUtil util =new DaoUtil();

    @Override
    public Boolean addRoom(Room room) {
        Connection con=util.getCon();
        PreparedStatement preparedStatement=null;
        String sql="insert into room (room_type,room_price,room_breakfast,room_area,room_high) values (?,?,?,?,?)";
        try {
            preparedStatement=con.prepareStatement(sql);
            if(room.getRoomType().equals(Constant.ROOMTYPE1))
            {
                preparedStatement.setInt(1,1);
            }
            else if (room.getRoomType().equals(Constant.ROOMTYPE2))
            {
                preparedStatement.setInt(1,2);
            }
            else if(room.getRoomType().equals(Constant.ROOMTYPE3))
            {
                preparedStatement.setInt(1,3);
            }
            else if(room.getRoomType().equals(Constant.ROOMTYPE4))
            {
                preparedStatement.setInt(1,4);
            }
            else{
                preparedStatement.setInt(1,5);
            }
            preparedStatement.setDouble(2,room.getRoomPrice());
            preparedStatement.setInt(3,room.getRoomBreakfast());
            preparedStatement.setDouble(4,room.getRoomArea());
            preparedStatement.setInt(5,room.getRoomHigh());
            if(preparedStatement.executeUpdate()!=0)
            {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(preparedStatement,con);
        }

        return false;
    }

    @Override
    public ArrayList<Room> findAllRoom() {
        ArrayList<Room> rooms=new ArrayList<>();
        Connection connection=util.getCon();
        PreparedStatement preparedStatement=null;
        String sql="select * from room";
        try {
            preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next())
            {
                rooms.add(findRoom(resultSet));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(preparedStatement,connection);
        }
        return  rooms;
    }

    @Override
    public Room findRoom( ResultSet resultSet) {
        Room room=new Room();
        try {
            room.setRoomPrice(resultSet.getDouble("room_price"));
            room.setRoomArea(resultSet.getDouble("room_area"));
            room.setRoomHigh(resultSet.getInt("room_high"));
            if(resultSet.getInt("room_type")==1)
            {
                room.setRoomType(Constant.ROOMTYPE1);
            }
            if(resultSet.getInt("room_type")==2)
            {
                room.setRoomType(Constant.ROOMTYPE2);
            }
            if(resultSet.getInt("room_type")==3)
            {
                room.setRoomType(Constant.ROOMTYPE3);
            }
            if(resultSet.getInt("room_type")==4)
            {
                room.setRoomType(Constant.ROOMTYPE4);
            }
            if(resultSet.getInt("room_type")==5)
            {
                room.setRoomType(Constant.ROOMTYPE5);
            }
            room.setRoomBreakfast(resultSet.getInt("room_breakfast"));
            room.setRoomUser(resultSet.getInt("room_user"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;

    }




}
