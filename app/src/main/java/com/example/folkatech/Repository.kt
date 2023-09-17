package com.example.folkatech

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    companion object {
        @Volatile
        private var instance: Repository? = null
        fun getInstance():Repository =
            instance ?: synchronized(this) {
                instance ?: Repository()
            }.also { instance = it }
    }

    private var _data = MutableLiveData<List<ResponseData>>()
    var data: LiveData<List<ResponseData>> = _data


    fun getData() {
        val client = ApiConfig.getApiService().getData()
        client.enqueue(object : Callback<List<ResponseData>> {
            override fun onResponse(
                call: Call<List<ResponseData>>,
                response: Response<List<ResponseData>>
            ) {
                if (response.isSuccessful) {
                    Log.e("dataResponse", "onResponse: ${response.message()}")
                    _data.value = response.body()
                } else {
                    Log.e("data", "onResponse: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<List<ResponseData>>, t: Throwable) {
                Log.e("dataFailure", "onFailure: ${t.message}")
            }
        })
    }


}