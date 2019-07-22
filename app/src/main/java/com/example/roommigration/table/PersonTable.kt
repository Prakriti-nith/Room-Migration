package com.example.roommigration.table

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase



class PersonTable {
    var TABLE_NAME = "PERSON_TABLE"
    var ID = "id"
    var NAME = "name"
    var ROLLNO = "rollNo"

    var createQuery = "CREATE TABLE " + "'PERSON_TABLE' (" +

            "'id' INTEGER PRIMARY KEY AUTOINCREMENT," +

            "'name' TEXT," + // 1: orderId

            "'rollNo' TEXT);"

    fun createTable(db: SQLiteDatabase) {
        db.execSQL(createQuery)
    }

    fun updateTable(db: SQLiteDatabase) {
        val sql = "DROP TABLE IF EXISTS $TABLE_NAME"
        db.execSQL(sql)
        createTable(db)
    }

    fun insert(db: SQLiteDatabase, cv: ContentValues): Long {
        return db.insert(TABLE_NAME, null, cv)
    }

    fun select(db: SQLiteDatabase, selection: String?): Cursor {
        return db.query(TABLE_NAME, null, selection, null, null, null, null, null)
    }

    fun delete(db: SQLiteDatabase, whereClause: String?): Int {
        return db.delete(TABLE_NAME, whereClause, null)
    }

    fun update(db: SQLiteDatabase, whereClause: String?, cv: ContentValues): Int {
        return db.update(TABLE_NAME, cv, whereClause, null)
    }
}