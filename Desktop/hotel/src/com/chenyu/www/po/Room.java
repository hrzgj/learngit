package com.chenyu.www.po;

public class Room
{
    private  int roomID;
    private  int roomType;
    private  double roomPrice;
    private  int roomBreakfast;
    private  double roomArea;
    private  int roomUser;
    private  int roomHigh;
    private  String roomPriceAndRoomType;

    public int getRoomUser() {
        return roomUser;
    }

    public void setRoomUser(int roomUser) {
        this.roomUser = roomUser;
    }

    public int getRoomBreakfast() {
        return roomBreakfast;
    }

    public void setRoomBreakfast(int roomBreakfast) {
        this.roomBreakfast = roomBreakfast;
    }

    public String getRoomPriceAndRoomType() {
        return roomPriceAndRoomType;
    }

    public void setRoomPriceAndRoomType(String roomPriceAndRoomType) {
        this.roomPriceAndRoomType = roomPriceAndRoomType;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }



    public double getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(double roomArea) {
        this.roomArea = roomArea;
    }



    public int getRoomHigh() {
        return roomHigh;
    }

    public void setRoomHigh(int roomHigh) {
        this.roomHigh = roomHigh;
    }
}
