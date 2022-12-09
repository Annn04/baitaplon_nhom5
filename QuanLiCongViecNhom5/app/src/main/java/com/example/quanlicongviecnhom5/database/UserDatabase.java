package com.example.quanlicongviecnhom5.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.quanlicongviecnhom5.model.KeHoach;
import com.example.quanlicongviecnhom5.model.User;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    private static UserDatabase instance;
    public static synchronized UserDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "user")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract UserDAO UserDAO();
}
