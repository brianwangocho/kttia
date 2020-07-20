package com.example.budgetia.Repository

import androidx.lifecycle.LiveData
import com.example.budgetia.dao.UserDao

class UserRepository (private val userDao:UserDao){


     suspend fun loginUser(email:String,password:String):Int{

     return userDao.loginUser(email,password)
    }


}