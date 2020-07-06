package com.example.budgetia.roomdatabase

import android.content.Context
import androidx.room.*
import com.example.budgetia.dao.ExpenseTypeDao
import com.example.budgetia.dao.ExpensesDao
import com.example.budgetia.dao.UserDao
import com.example.budgetia.models.ExpenseType
import com.example.budgetia.models.Expenses
import com.example.budgetia.models.User
import com.example.budgetia.util.DateConvertor

//add entities of classes here which will rep the data in the db
@Database(entities = arrayOf(User::class,ExpenseType::class, Expenses::class), version = 1, exportSchema = false)
@TypeConverters(DateConvertor::class )
public abstract class MyRoomDatabase:RoomDatabase(){

//    add daos here
    abstract fun userDao():UserDao
    abstract fun expensesDao():ExpensesDao
    abstract fun expensetypeDao():ExpenseTypeDao



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

