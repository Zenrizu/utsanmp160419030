package id.ac.ubaya.informatika.mnchealthcare_160419030.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.mnchealthcare_160419030.R
import id.ac.ubaya.informatika.mnchealthcare_160419030.util.loadImage
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView4.loadImage("https://hatrabbits.com/wp-content/uploads/2017/01/random.jpg", null)

        buttonDetailObatDariMain.setOnClickListener {
            //dapatkan action yg ingin dijalankan
            val action = MainFragmentDirections.actionToListObat()
            Navigation.findNavController(it).navigate(action)
        }
        buttonLogout.setOnClickListener{
            //dapatkan action yg ingin dijalankan
            val action = MainFragmentDirections.actionItemHomeToItemLogout()
            Navigation.findNavController(it).navigate(action)
        }
//        buttonDetailDokterDariMain.setOnClickListener {
//            //dapatkan action yg ingin dijalankan
//            val action = MainFragmentDirections.actionToListDokter()
//            Navigation.findNavController(it).navigate(action)
//        }
    }
}