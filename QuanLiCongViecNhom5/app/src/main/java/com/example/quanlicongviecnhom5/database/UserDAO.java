package com.example.quanlicongviecnhom5.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quanlicongviecnhom5.model.KeHoach;
import com.example.quanlicongviecnhom5.model.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void inSert(User user);
    @Query("SELECT * FROM user")
    List<User> getListUser();
    @Delete
    void deleteKeHoach(User user);
    @Update
    void updateKeHoach(User user);
}
