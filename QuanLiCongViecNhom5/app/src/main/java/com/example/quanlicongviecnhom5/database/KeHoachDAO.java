package com.example.quanlicongviecnhom5.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quanlicongviecnhom5.model.KeHoach;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface KeHoachDAO {
    @Insert
    void inSert(KeHoach keHoach);
    @Query("SELECT * FROM kehoach")
    List<KeHoach> getListKeHoach();
    @Delete
    void deleteKeHoach(KeHoach keHoach);
    @Update
    void updateKeHoach(KeHoach keHoach);
}
