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

class ListViewDoctorModel(application: Application) :AndroidViewModel(application){
    val doctorLiveData = MutableLiveData<ArrayList<Doctor>>()
    val doctorLoadErrorLiveData = MutableLiveData<Boolean>()
    val loadingLiveData = MutableLiveData<Boolean>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {
//        studentsLiveData.value = arrayListOf(
//            Student("16055","Nonie","1998/03/28","5718444778","http://dummyimage.com/75x100.jpg/cc0000/ffffff"),
//            Student("13312","Rich","1994/12/14","3925444073","http://dummyimage.com/75x100.jpg/5fa2dd/ffffff"),
//            Student("11204","Dinny","1994/10/07","6827808747","http://dummyimage.com/75x100.jpg/5fa2dd/ffffff1")
//        )
        doctorLoadErrorLiveData.value = false
        loadingLiveData.value = true
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://api.npoint.io/73ac8b710dc31fc05950"
        val stringRequest = StringRequest(
            Request.Method.GET, url, {
                val sType = object : TypeToken<ArrayList<Doctor>>() {}.type
                val result = Gson().fromJson<ArrayList<Doctor>>(it, sType)
                doctorLiveData.value = result
                loadingLiveData.value = false
                Log.d("showvolley", it)
            },{
                Log.d("errorvolley", it.toString())
                doctorLoadErrorLiveData.value = true
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