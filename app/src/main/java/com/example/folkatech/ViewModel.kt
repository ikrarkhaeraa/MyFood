package com.example.folkatech

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import okhttp3.MultipartBody

class ViewModel(private val repo: Repository) : ViewModel() {

    var data: LiveData<List<ResponseData>> = repo.data

    fun getData() {
        repo.getData()
    }


}