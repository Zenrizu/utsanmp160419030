package id.ac.ubaya.informatika.mnchealthcare_160419030.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.mnchealthcare_160419030.R
import id.ac.ubaya.informatika.mnchealthcare_160419030.util.loadImage
import id.ac.ubaya.informatika.mnchealthcare_160419030.viewmodel.DetailDoktorViewModel
import kotlinx.android.synthetic.main.dokter_list_item.*
import kotlinx.android.synthetic.main.dokter_list_item.view.*
import kotlinx.android.synthetic.main.fragment_detail_dokter.*

class detailDokter : Fragment() {
    private lateinit var viewModel: DetailDoktorViewModel
    private val doctorListAdapter  = DoctorListAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_dokter, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(DetailDoktorViewModel::class.java)
        arguments?.let {
            val idPerson = detailDokterArgs.fromBundle(requireArguments()).idDoctor
            viewModel.fetch(idPerson)
        }
        observeViewModel()
        buttonContact.setOnClickListener{
            val action = detailDokterDirections.actionDetailtoReserve()
            Navigation.findNavController(it).navigate(action)
        }
    }
    fun observeViewModel() {
        viewModel.doctorLiveData.observe(viewLifecycleOwner, Observer {
            textNama.text = it.name
            textEmail.text = it.email
            textUmur.text = it.age
            textDesc.text = it.description
            textPengalaman.text = it.pengalaman.toString() +" Tahun"
            textJam.text = it.jam_praktik
            ratingBar.setProgress(it.rating)
            if(it.weekend == true){ checkBoxWeekend.setChecked(true)}
            else{checkBoxWeekend.setChecked(false)}
            doctorImageView.loadImage(it.photo_url, progressLoadDoc)



//            editID.setText(it.id)
//            editName.setText(it.name)
//            editDob.setText(it.dob)
//            editPhone.setText(it.phone)
        })

    }
}