package id.ac.ubaya.informatika.mnchealthcare_160419030.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ubaya.informatika.mnchealthcare_160419030.R
import id.ac.ubaya.informatika.mnchealthcare_160419030.viewmodel.ListViewDoctorModel
import id.ac.ubaya.informatika.mnchealthcare_160419030.viewmodel.ListViewObatModel
import kotlinx.android.synthetic.main.fragment_list_obat.*

class ListObatFragment : Fragment() {
    private lateinit var viewModel: ListViewObatModel
    private val obatListAdapter  = ObatListAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_obat, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        viewModel = ViewModelProvider(this).get(ListViewObatModel::class.java)
        viewModel.refresh()

        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = obatListAdapter
        observeViewModel()
        refreshLayout.setOnRefreshListener {
            recView.visibility = View.GONE
            textError.visibility = View.GONE
            progressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }
    }
    fun observeViewModel() {
        viewModel.obatLiveData.observe(viewLifecycleOwner, Observer {
            obatListAdapter.UpdateObatList(it)
        })
        viewModel.obatLoadErrorLiveData.observe(viewLifecycleOwner, Observer {
            textError.visibility = if(it) View.VISIBLE else View.GONE
//            if(it == true) {
//                textError.visibility = View.VISIBLE
//            } else {
//                textError.visibility = View.GONE
//            }
        })
        viewModel.loadingLiveData.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                recView.visibility = View.GONE
                progressLoad.visibility = View.VISIBLE
            } else {
                recView.visibility = View.VISIBLE
                progressLoad.visibility = View.GONE
            }
        })

    }
}