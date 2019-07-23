package com.example.roommigration.database

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import com.example.roommigration.dao.PersonDao
import com.example.roommigration.entities.PersonEntity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LocalUserDataSource(context: Context) {

    private var personDao: PersonDao
    var mutableLiveData = MutableLiveData<List<PersonEntity>>()

    init {
        val db = AppDatabase(context)
        personDao = db.personDao()
    }

    fun insertOrUpdatePerson(person: PersonEntity, h : () -> Unit) {
        GlobalScope.launch {
            personDao.insert(person)
            h()
        }
    }

    fun fetchData() {
        GlobalScope.launch {
            mutableLiveData.postValue(personDao.getAll())
        }
    }
}
