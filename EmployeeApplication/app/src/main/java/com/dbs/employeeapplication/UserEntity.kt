package com.dbs.employeeapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dashboard-table")
data class UserEntity(
    @PrimaryKey val user:String
)