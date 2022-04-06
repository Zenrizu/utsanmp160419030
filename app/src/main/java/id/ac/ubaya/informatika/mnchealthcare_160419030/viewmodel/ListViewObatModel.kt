package id.ac.ubaya.informatika.mnchealthcare_160419030.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.informatika.mnchealthcare_160419030.model.Doctor
import id.ac.ubaya.informatika.mnchealthcare_160419030.model.Obat

class ListViewObatModel(application: Application) : AndroidViewModel(application){
    val obatLiveData = MutableLiveData<ArrayList<Obat>>()
    val obatLoadErrorLiveData = MutableLiveData<Boolean>()
    val loadingLiveData = MutableLiveData<Boolean>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {
        obatLoadErrorLiveData.value = false
        loadingLiveData.value = true
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://api.npoint.io/0bbf76181245973fc5f9"
        val stringRequest = StringRequest(
            Request.Method.GET, url, {
                val sType = object : TypeToken<ArrayList<Obat>>() {}.type
                val result = Gson().fromJson<ArrayList<Obat>>(it, sType)
                obatLiveData.value = result
                loadingLiveData.value = false
                Log.d("showvolley", it)
            },{
                Log.d("errorvolley", it.toString())
                obatLoadErrorLiveData.value = true
                loadingLiveData.value = false
            }
        ).apply {
            tag = TAG
        }
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}