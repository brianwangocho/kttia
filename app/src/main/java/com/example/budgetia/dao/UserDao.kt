package com.example.budgetia.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.budgetia.models.User

@Dao
interface UserDao{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend  fun createUser(user: User):Long

    @Query("SELECT COUNT(*) FROM users where phone= :phone and password= :password")
     suspend fun loginUser(phone:String,password:String):Int

    @Query("SELECT COUNT(*) FROM users where phone= :phone")
    suspend fun findIfUserExist(phone:String):Int

    @Query("DELETE  FROM users where id = :id")
    suspend fun deleteUserAccount(id:Int)


}