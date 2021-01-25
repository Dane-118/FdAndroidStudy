package com.example.room_study.dao

import android.content.Context
import androidx.room.Room


/**

@author fangdongdong
@description:
@date : 2021/1/25 11:24
 */
class DaoManager(private val context: Context) {

    private var db: AppDatabase? = null
    private var mUserDao: UserDao? = null

    companion object {
        //数据库名称
        private var mDaoManager: DaoManager? = null

        fun getInstance(context: Context): DaoManager? {
            if (mDaoManager == null) {
                synchronized(DaoManager::class.java) {
                    if (mDaoManager == null) {
                        mDaoManager = DaoManager(context)
                    }
                }
            }
            return mDaoManager
        }
    }

    @get:Synchronized
    val appDatabase: AppDatabase
        get() {
            if (null == db) {
                db = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java, "database-name"
                ).build()
            }
            return db!!
        }

    @get:Synchronized
    val userDao:UserDao?
    get() {
        if (null == mUserDao){
            mUserDao = appDatabase.userDao()
        }
        return mUserDao
    }


}