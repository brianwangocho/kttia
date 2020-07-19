package com.example.budgetia.loginui

import android.app.Application

import androidx.lifecycle.ViewModel

import com.example.budgetia.Repository.UserRepository
import com.example.budgetia.roomdatabase.MyRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserViewModel(application: Application):ViewModel(){
    val userDao = MyRoomDatabase.getDatabase(application).userDao()
    private var userRepository = UserRepository(userDao)

    fun loginUser(username:String,password:String) = CoroutineScope(Dispatchers.Main).launch {
        userRepository.loginUser(username,password)

    }





}