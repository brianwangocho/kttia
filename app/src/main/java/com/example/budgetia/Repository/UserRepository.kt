package com.example.budgetia.Repository

import androidx.lifecycle.LiveData
import com.example.budgetia.dao.UserDao
import com.example.budgetia.models.User

class UserRepository (private val userDao:UserDao){


     suspend fun loginUser(phone:String,password:String):Int{

     return userDao.loginUser(phone,password)
    }

    suspend fun checkUserExist(phone:String):Int{
        return userDao.findIfUserExist(phone)
    }

    suspend  fun registerUser(user: User):Long{
        return userDao.createUser(user)
    }


}