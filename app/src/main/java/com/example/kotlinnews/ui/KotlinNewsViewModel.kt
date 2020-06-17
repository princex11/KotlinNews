package com.example.kotlinnews.ui

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import android.util.Log
import android.view.Display
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinnews.databinding.DetailKotlinNewsFragmentBinding
import com.example.kotlinnews.databinding.KotlinNewsFragmentBinding
import com.example.kotlinnews.model.Model
import com.example.kotlinnews.network.KotlinNewsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class KotlinNewsViewModel : ViewModel() {

    private val _response = MutableLiveData<Model?>()
    val response : LiveData<Model?>
    get() = _response
    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob+Dispatchers.Main)
    init {
        getKotlinNews()
    }


    private fun getKotlinNews(){
          coroutineScope.launch {
              val getKotlinNewsDeferred = KotlinNewsApi.retrofitService.getKotlinNews()
              try {
                  _response.value = getKotlinNewsDeferred.await()
              }catch (e: Exception){
                  Log.d("Exception", "${e.message}")
              }
          }
    }

    fun showHideProgressBar(binding: KotlinNewsFragmentBinding){
        if(response.value!=null){
            binding.pb.visibility=View.GONE
        }else{
            binding.pb.visibility=View.VISIBLE
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }




}
