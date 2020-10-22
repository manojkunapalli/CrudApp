package com.example.crudapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Subscriber::class],version = 1)
abstract class SubscriberDatabase : RoomDatabase() {
    abstract val subscriberDAO : SubscriberDAO

    companion object {
        @Volatile
        private var INSTANCE : SubscriberDatabase? = null
            fun getInstance(context :Context) :SubscriberDatabase{
                synchronized(this) {
                    var instance = INSTANCE
                        if(instance == null){
                            instance = Room.databaseBuilder(
                                context.applicationContext,
                                SubscriberDatabase::class.java,
                                "subscriber_data_database"
                                ).build()
                        }
                    return instance
                }
            }
    }
}

/*
* this represents overall database
* creating number of instances for a room database might lead to performance issues & unexpected issues,
* So we can use singleton object as companion object,
* volatile annotation will makes available to other threads
*
*
* */