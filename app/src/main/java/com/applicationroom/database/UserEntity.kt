package com.applicationroom.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = TABLE_USERS)
data class UserEntity(

    @ColumnInfo(name = "user_id") @PrimaryKey val uuid: String,
    @ColumnInfo(name = "user_name") val name: String,
    val user_height: Double,
    val user_weight: Double,
    val user_email: String,
    val user_password: String


)

fun UserEntity.toUser() = User(
    uuid,
    name,
    user_height,
    user_weight,
    user_email,
    user_password
)