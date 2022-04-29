package com.applicationroom.database

import android.content.Context
import androidx.room.Room

class DataBaseManager {
    lateinit var database: AppDataBase

    fun initializeDb(context: Context){
        createBD(context)
    }

    private fun createBD(context: Context){
        database = Room.databaseBuilder(context, AppDataBase::class.java, DATABASE_NAME).build()

    }

    companion object{
        val instance = DataBaseManager()
    }
}