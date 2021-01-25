package com.example.room_study.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.room_study.entity.User;

/**
 * @author fangdongdong
 * @description:
 * @date : 2021/1/25 11:22
 */
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();

}
