package id.ac.ubaya.informatika.mnchealthcare_160419030.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.mnchealthcare_160419030.R
import id.ac.ubaya.informatika.mnchealthcare_160419030.model.Doctor
import id.ac.ubaya.informatika.mnchealthcare_160419030.util.loadImage
import kotlinx.android.synthetic.main.dokter_list_item.view.*

class DoctorListAdapter (val doctorList:ArrayList<Doctor>):RecyclerView.Adapter<DoctorListAdapter.DoctorViewHolder>() {
    class DoctorViewHolder(var view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.dokter_list_item, parent, false)
        return DoctorViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        val doc = doctorList[position]
        with(holder.view){
            txtAge.text = doc.age
            txtEmail.text = doc.email
            txtDoctorName.text = doc.name


            buttonDetail.setOnClickListener {
                val action = listDokterFragmentDirections.actionDetailDokter(doc.id.toString())
                Navigation.findNavController(it).navigate(action)
            }
//            buttonChat.setOnClickListener{
//                val action = listDokterFragmentDirections.actionListToChat()
//                Navigation.findNavController(it).navigate(action)
//            }
            imageStudentPhoto.loadImage(doc.photo_url, progressLoadingDocPhoto)
        }
//        holder.view.txtId.text =studentList[position].id
//        holder.view.txtName.text =studentList[position].name
    }

    override fun getItemCount() = doctorList.size
    fun UpdateObatList(newDoctorList: ArrayList<Doctor>){
        doctorList.clear()
        doctorList.addAll(newDoctorList)
        notifyDataSetChanged()
    }
}