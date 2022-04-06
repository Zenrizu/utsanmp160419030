package id.ac.ubaya.informatika.mnchealthcare_160419030.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.mnchealthcare_160419030.R
import id.ac.ubaya.informatika.mnchealthcare_160419030.model.Doctor
import id.ac.ubaya.informatika.mnchealthcare_160419030.model.Obat
import id.ac.ubaya.informatika.mnchealthcare_160419030.util.loadImage
import kotlinx.android.synthetic.main.dokter_list_item.view.*
import kotlinx.android.synthetic.main.obat_list_item.view.*

class ObatListAdapter (val obatList:ArrayList<Obat>): RecyclerView.Adapter<ObatListAdapter.ObatViewHolder>() {
    class ObatViewHolder(var view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.obat_list_item, parent, false)
        return ObatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ObatViewHolder, position: Int) {
        val obat = obatList[position]
        with(holder.view){
            txtListObat.text = obat.nama
            txtType.text = obat.type
        }
    }

    override fun getItemCount() = obatList.size
    fun UpdateObatList(newObatList: ArrayList<Obat>){
        obatList.clear()
        obatList.addAll(newObatList)
        notifyDataSetChanged()
    }
}