package com.example.quanlicongviecnhom5.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.quanlicongviecnhom5.model.KeHoach;

@Database(entities = {KeHoach.class}, version = 1)
public abstract class KeHoachDatabase extends RoomDatabase {
    private static KeHoachDatabase instance;
    public static synchronized KeHoachDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), KeHoachDatabase.class, "kehoach")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract KeHoachDAO keHoachDAO();
}
