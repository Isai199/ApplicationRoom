package com.applicationroom

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applicationroom.database.DataBaseManager
import com.applicationroom.database.MyCoroutines
import com.applicationroom.database.User
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    fun saveUser(user: User){
        viewModelScope.launch{
           val userDao = DataBaseManager.instance.database.userDao()
           MyCoroutines(userDao).save(user)
        }
    }

    fun deleteUser(user: User){
        viewModelScope.launch{
            val userDao = DataBaseManager.instance.database.userDao()
            MyCoroutines(userDao).delete(user)
        }
    }

    val savedUsers = MutableLiveData<List<User>>()

    fun getUsers(){
        viewModelScope.launch{
            val userDao = DataBaseManager.instance.database.userDao()
            savedUsers.value = MyCoroutines(userDao).getUsers().value
        }
    }


}