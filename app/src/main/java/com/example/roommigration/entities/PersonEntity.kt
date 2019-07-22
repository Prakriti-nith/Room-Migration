package com.example.roommigration.entities

data class PersonEntity(
    var name: String,
    var rollNo: String
) {
    override fun toString(): String {
        return "PersonEntity(name='$name', rollNo='$rollNo')"
    }
}
