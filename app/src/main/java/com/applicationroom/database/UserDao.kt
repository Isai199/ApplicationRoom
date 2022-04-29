package com.applicationroom.database

import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM $TABLE_USERS")
    fun getUsersFromdatabase(): List<UserEntity>

    @Query("SELECT * FROM $TABLE_USERS where user_id = :uuid")
    fun getUserByUuid(uuid: String): UserEntity

    @Delete
    fun delete(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(user: UserEntity)
}