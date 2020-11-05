package com.example.safari.dashboard;

public class Booking {

        private String firstname, lastname,hotelname, roomtype,date,time;

    public Booking(String firstname, String lastname, String hotelname, String roomtype, String date, String time) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.hotelname = hotelname;
        this.roomtype = roomtype;
        this.date = date;
        this.time = time;
    }

    public Booking() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
