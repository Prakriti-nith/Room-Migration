package com.example.roommigration.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PERSON_TABLE")
data class PersonEntity(
    @PrimaryKey
    var id: Int,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "rollNo")
    var rollNo: String
) {
    override fun toString(): String {
        return "PersonEntity(name='$name', rollNo='$rollNo')"
    }
}
