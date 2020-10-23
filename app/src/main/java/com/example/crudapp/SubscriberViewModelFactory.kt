package com.example.crudapp

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.crudapp.database.SubscriberRepository
import java.lang.IllegalArgumentException

class SubscriberViewModelFactory(private val repository: SubscriberRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SubscribeViewModel::class.java)){
            return SubscribeViewModel(repository) as T
        }
            throw IllegalArgumentException("Unknown View Model Class")
    }
}