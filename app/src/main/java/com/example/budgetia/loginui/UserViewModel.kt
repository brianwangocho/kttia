package com.example.budgetia.loginui

import android.app.Application

import androidx.lifecycle.ViewModel

import com.example.budgetia.Repository.UserRepository
import com.example.budgetia.roomdatabase.MyRoomDatabase


class UserViewModel(application: Application):ViewModel(){
    val userDao = MyRoomDatabase.getDatabase(application).userDao()
    private var userRepository = UserRepository(userDao)



}