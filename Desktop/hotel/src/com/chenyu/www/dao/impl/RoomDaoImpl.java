package com.chenyu.www.dao.impl;

import com.chenyu.www.po.Room;
import com.chenyu.www.po.User;
import com.chenyu.www.util.DaoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDaoImpl implements RoomDao {
    private  static DaoUtil util =new DaoUtil();

    //增加房间到数据库
    @Override
    public Boolean addRoom(Room room) {
        Connection con=util.getCon();
        PreparedStatement preparedStatement=null;
        String sql="insert into room (room_type,room_price,room_breakfast,room_area,room_high) values (?,?,?,?,?)";
        try {
            preparedStatement=con.prepareStatement(sql);
            preparedStatement.setInt(1,room.getRoomType());
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

    //找出所有房间信息
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

    //根据resultSet将数据库的信息存入Room类
    @Override
    public Room findRoom( ResultSet resultSet) {
        Room room=new Room();
        try {
            room.setRoomID(resultSet.getInt("room_id"));
            room.setRoomPrice(resultSet.getDouble("room_price"));
            room.setRoomArea(resultSet.getDouble("room_area"));
            room.setRoomHigh(resultSet.getInt("room_high"));
            if(resultSet.getInt("room_type")==1)
            {
                room.setRoomType(1);
            }
            if(resultSet.getInt("room_type")==2)
            {
                room.setRoomType(2);
            }
            if(resultSet.getInt("room_type")==3)
            {
                room.setRoomType(3);
            }
            if(resultSet.getInt("room_type")==4)
            {
                room.setRoomType(4);
            }
            if(resultSet.getInt("room_type")==5)
            {
                room.setRoomType(5);
            }
            room.setRoomBreakfast(resultSet.getInt("room_breakfast"));
            room.setRoomUser(resultSet.getInt("room_user"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return room;

    }

    //找出房间共有几个
    @Override
    public int findRow() {
        Connection connection=util.getCon();
        String sql="select * from room";
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.last();
            return resultSet.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(preparedStatement,connection);
        }
        return 0;
    }

    //更新房间外键
    @Override
    public Boolean addRoomAndUser(User user, int i) {
        Connection connection=util.getCon();
        PreparedStatement preparedStatement=null;
        String sql="update room set room_user=? where room_id=? ";
        try {
            preparedStatement=connection.prepareStatement(sql);
            ArrayList<Room> rooms=findAllRoom();
            Room room=rooms.get(i);
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setInt(2,room.getRoomID());
            return  preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            util.close(preparedStatement,connection);
        }

        return  null;
    }

    //找出预定房间的用户的id
    @Override
    public int findRoomUser(int i) {
        ArrayList<Room> rooms=findAllRoom();
        Room room=rooms.get(i);
        Connection connection=util.getCon();
        PreparedStatement preparedStatement=null;
        String sql="select * from room where room_id=?";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,room.getRoomID());
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next())
            {
                return resultSet.getInt("room_user");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            util.close(preparedStatement,connection);
        }
        return -1;
    }

    //更新房间
    @Override
    public Boolean updateRoom(Room room) {
        Connection connection=util.getCon();
        PreparedStatement preparedStatement=null;
        String sql="update room set room_type=?,room_price=?,room_breakfast=?,room_area=?,room_high=? where room_id=?";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,room.getRoomType());
            preparedStatement.setDouble(2,room.getRoomPrice());
            preparedStatement.setInt(3,room.getRoomBreakfast());
            preparedStatement.setDouble(4,room.getRoomArea());
            preparedStatement.setDouble(5,room.getRoomHigh());
            preparedStatement.setInt(6,room.getRoomID());
            if(preparedStatement.execute())
            {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            util.close(preparedStatement,connection);
        }
        return false;
    }

}
