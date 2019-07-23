package com.example.roommigration

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.roommigration.database.LocalUserDataSource
import com.example.roommigration.entities.PersonEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var arrayListPerson: List<PersonEntity> = ArrayList()
    private lateinit var dataSource: LocalUserDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataSource = LocalUserDataSource(this)

        insertDatabase()
    }

    private fun insertDatabase() {
        dataSource.insertOrUpdatePerson(PersonEntity(3, "Shagun", "1234")) {
            dataSource.insertOrUpdatePerson(PersonEntity(4, "Anurag", "5678")) {
                fetchDatabaseToArrayList()
            }
        }

    }

    private fun fetchDatabaseToArrayList() {
        dataSource.fetchData()
        dataSource.mutableLiveData.observe(this, Observer<List<PersonEntity>> { itemAndPeople ->
            itemAndPeople?.let {
                arrayListPerson = it
                name1.text = arrayListPerson[0].name
                rollNo1.text = arrayListPerson[0].rollNo
                name2.text = arrayListPerson[1].name
                rollNo2.text = arrayListPerson[1].rollNo
            }
        })
    }
}
