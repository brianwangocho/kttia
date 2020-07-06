package com.example.budgetia.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.budgetia.models.User

@Dao
interface UserDao{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend  fun createUser(user: User)

    @Query("SELECT * FROM users where email= :email and password= :password")
    suspend fun loginUser(email:String,password:String):Long

    @Query("DELETE  FROM users where id = :id")
    suspend fun deleteUserAccount(id:Long)


}