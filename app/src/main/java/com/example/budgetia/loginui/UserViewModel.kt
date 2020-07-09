package com.example.budgetia.loginui

import android.app.Application
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.budgetia.Repository.UserRepository
import com.example.budgetia.roomdatabase.MyRoomDatabase
import kotlinx.coroutines.launch

class UserViewModel(application: Application):ViewModel(){
    val userDao = MyRoomDatabase.getDatabase(application).userDao()
    private var userRepository = UserRepository(userDao)


    @Bindable
    val inputEmail = MutableLiveData<String>()

    @Bindable
    val inputPassword = MutableLiveData<String>()

    @Bindable
    val loginButtonText = MutableLiveData<String>()

    init{
        loginButtonText.value="login"
    }

    fun login(email:String,password:String)=viewModelScope.launch {
        userRepository.loginUser(email,password)
    }

}