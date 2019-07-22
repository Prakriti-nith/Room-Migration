package com.example.roommigration

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.roommigration.database.MySqliteOpenHelper
import com.example.roommigration.entities.PersonEntity
import com.example.roommigration.table.PersonTable
import android.widget.Toast
import android.content.ContentValues
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var arrayListPerson: ArrayList<PersonEntity> = ArrayList()
    private var arrayListId: ArrayList<Int> = ArrayList()
    private val personTable = PersonTable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        insertDatabase("Shagun", "1234")
        insertDatabase("Anurag", "5678")

        fetchDatabaseToArrayList()

        name1.text = arrayListPerson[0].name
        rollNo1.text = arrayListPerson[0].rollNo
        name2.text = arrayListPerson[1].name
        rollNo2.text = arrayListPerson[1].rollNo
    }

    private fun insertDatabase(name: String, rollNo: String): Long {
        val helper = MySqliteOpenHelper(this@MainActivity)
        val db = helper.writableDatabase

        val cv = ContentValues()
        cv.put(personTable.NAME, name)
        cv.put(personTable.ROLLNO, rollNo)

        val id = personTable.insert(db, cv)
        if (id > 0) {
//            Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this@MainActivity, "Try Again", Toast.LENGTH_SHORT).show()
        }
        db.close()
        return id
    }

    private fun fetchDatabaseToArrayList() {
        arrayListPerson.clear()
        val mySqliteOpenHelper = MySqliteOpenHelper(this)
        val db = mySqliteOpenHelper.readableDatabase
        val cursor = personTable.select(db, null)
        while (cursor.moveToNext()) {
            val id = cursor.getInt(0)
            val name = cursor.getString(1)
            val rollNo = cursor.getString(2)

            val personEntity = PersonEntity(name, rollNo)
            arrayListPerson.add(personEntity)
            arrayListId.add(id)
        }
        cursor.close()
        db.close()
    }
}
