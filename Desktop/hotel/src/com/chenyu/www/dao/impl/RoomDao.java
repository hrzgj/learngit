package com.chenyu.www.dao.impl;

import com.chenyu.www.po.Room;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface RoomDao {
    public  Boolean addRoom(Room room);
    ArrayList<Room> findAllRoom();
    Room findRoom(ResultSet resultSet);
}
