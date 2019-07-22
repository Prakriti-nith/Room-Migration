package com.example.roommigration.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.roommigration.table.PersonTable


class MySqliteOpenHelper(private var context: Context) : SQLiteOpenHelper(context, "mydb.db", null, 1) {

    val personTable = PersonTable()

    override fun onCreate(db: SQLiteDatabase) {
        personTable.createTable(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        personTable.updateTable(db)
    }
}
