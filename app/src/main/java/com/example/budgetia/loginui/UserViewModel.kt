package com.example.budgetia.loginui

import android.app.Application
import android.util.Log

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.budgetia.Repository.UserRepository
import com.example.budgetia.roomdatabase.MyRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserViewModel(application: Application):ViewModel(){
    val userDao = MyRoomDatabase.getDatabase(application).userDao()
    private var userRepository = UserRepository(userDao)
    private  val TAG = "LoginViewModel"
    var count:String  =""

    fun authenticateUser(email:String,password:String): String {


        viewModelScope.launch {
            count = userRepository.loginUser(email,password).toString()


        }
        Log.i(TAG,count)
        return count

    }



}