package com.example.crudapp.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubscriberDAO {
    @Insert
    suspend fun insertSubscriber(subscriber: Subscriber) : Long

    @Update
    suspend fun updateSubscriber(subscriber: Subscriber)

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber)

    @Query("DELETE FROM subscriber_data_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM subscriber_data_table")
    fun getAllSubscribers() : LiveData<List<Subscriber>>
}

/*
* all operations done here or cursor operations are done here
* insert fun will return id's inserted in long format
* update & delete fun's can return number of id's updated & deleted
* since getAllSubscribers() will use live data, no need of suspend functions
* */