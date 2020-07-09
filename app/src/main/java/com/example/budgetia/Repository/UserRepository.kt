package com.example.budgetia.Repository

import com.example.budgetia.dao.UserDao

class UserRepository (private val userDao:UserDao){


    suspend fun loginUser(email:String,password:String){
        userDao.loginUser(email,password)

    }
}