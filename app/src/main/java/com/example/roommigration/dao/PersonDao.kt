package com.example.roommigration.dao

import androidx.room.*
import com.example.roommigration.entities.PersonEntity

@Dao
interface PersonDao {
    @Query("SELECT * FROM PERSON_TABLE")
    fun getAll(): List<PersonEntity>

    @Insert
    fun insert(vararg person: PersonEntity)

    @Delete
    fun delete(person: PersonEntity)

    @Update
    fun updateTodo(vararg person: PersonEntity)
}
