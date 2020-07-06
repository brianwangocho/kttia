package com.example.budgetia.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.budgetia.dao.UserDao
import com.example.budgetia.models.User

//add entities of classes here which will rep the data in the db
@Database(entities = arrayOf(User::class), version = 1, exportSchema = false)
public abstract class MyRoomDatabase:RoomDatabase(){

//    add daos here
    abstract fun userDao():UserDao


    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: MyRoomDatabase? = null

        fun getDatabase(context: Context): MyRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyRoomDatabase::class.java,
                    "budgetia_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }



}

