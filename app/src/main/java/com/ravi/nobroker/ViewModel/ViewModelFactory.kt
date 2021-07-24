package com.ravi.nobroker.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.ravi.nobroker.repository.ListRepository

class ViewModelFactory(val repository:ListRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListViewModel(repository) as T
    }
}