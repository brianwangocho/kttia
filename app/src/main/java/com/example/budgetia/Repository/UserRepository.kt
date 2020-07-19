package com.example.budgetia.Repository

import androidx.lifecycle.LiveData
import com.example.budgetia.dao.UserDao

class UserRepository (private val userDao:UserDao){


     fun loginUser(email:String,password:String):LiveData<Int>{

     return userDao.loginUser(email,password)
    }


}