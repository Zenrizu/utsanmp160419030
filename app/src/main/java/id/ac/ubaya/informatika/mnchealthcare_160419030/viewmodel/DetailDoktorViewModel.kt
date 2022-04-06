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
import id.ac.ubaya.informatika.mnchealthcare_160419030.model.Doctor

class DetailDoktorViewModel(application: Application) : AndroidViewModel(application){
    val doctorLiveData = MutableLiveData<Doctor>()
    private var queue: RequestQueue? = null

    fun fetch(id:String) {
//        val student1 = Student("16055","Nonie","1998/03/28","5718444778","http://dummyimage.com/75x100.jpg/cc0000/ffffff")
//        studentLiveData.value = student1

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://192.168.1.14/anmp/detailDokter.php?id=$id"
//        val url = "http://localhost/anmp/detailDokter.php?id=$id"
        val stringRequest = StringRequest(
            Request.Method.GET, url, {
//                val sType = object : TypeToken<ArrayList<Student>>() {}.type
//                val result = Gson().fromJson<ArrayList<Student>>(it, sType)
                val result = Gson().fromJson(it, Doctor::class.java)
                doctorLiveData.value = result
                Log.d("showvolley", it)
            },{
                Log.d("errorvolley", it.toString())
            }
        ).apply {
            tag = "volleyTag"
        }
        queue?.add(stringRequest)
    }

}