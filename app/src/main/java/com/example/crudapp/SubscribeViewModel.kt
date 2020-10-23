package com.example.crudapp

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crudapp.database.Subscriber
import com.example.crudapp.database.SubscriberRepository
import kotlinx.coroutines.launch

class SubscribeViewModel(private val repository: SubscriberRepository) : ViewModel() {

    val subscribers = repository.subscribers

    @Bindable
    val inputName = MutableLiveData<String>()

    @Bindable
    val inputEmail = MutableLiveData<String>()

    @Bindable
    val saveOrUpdateButtonText = MutableLiveData<String>()

    @Bindable
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun saveOrUpdate() {
        //48.38 minutes
        val name = inputName.value!!
        val email = inputEmail.value!!
        insert(Subscriber(0,name,email))
        inputName.value = null
        inputEmail.value = null
    }

    fun clearAllOrDelete() {

    }

    fun insert(subscriber: Subscriber){
        viewModelScope.launch {
            repository.insert(subscriber)
        }
    }

    fun update(subscriber: Subscriber){
        viewModelScope.launch {
            repository.update(subscriber)
        }
    }

    fun delete(subscriber: Subscriber){
        viewModelScope.launch {
            repository.delete(subscriber)
        }
    }

    fun clearAll(){
        viewModelScope.launch {
            repository.deleteAll()
        }
    }
}