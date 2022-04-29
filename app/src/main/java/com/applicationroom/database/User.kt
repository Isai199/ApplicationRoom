package com.applicationroom.database

class User(
    user_id: String,
    user_name: String,
    user_height: Double,
    user_weight: Double,
    user_email: String,
    user_password: String

) {


    val user_id : String = user_id
    val user_name: String = user_name
    val user_height: Double = user_height
    val user_weight: Double = user_weight
    val user_email: String= user_email
    val user_password: String = user_password

}

fun User.toEntity() = UserEntity(
    user_id,
    user_name,
    user_height,
    user_weight,
    user_email,
    user_password
)