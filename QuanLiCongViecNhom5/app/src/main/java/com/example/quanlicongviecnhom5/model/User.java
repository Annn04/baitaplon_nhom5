package com.example.quanlicongviecnhom5.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {
    @PrimaryKey(autoGenerate = true)
    int id;
    String name = "";
    String phoneNumber = "";
    String passWord = "";
    public User(){

    }
    public User(String name, String phoneNumber, String passWord){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.passWord = passWord;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
