package id.ac.ubaya.informatika.mnchealthcare_160419030.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.mnchealthcare_160419030.R
import kotlinx.android.synthetic.main.fragment_reservation.*

class ReservationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reservation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonReserve.setOnClickListener{
                val action = ReservationFragmentDirections.actionReservetoChat()
                Navigation.findNavController(it).navigate(action)
            }
    }
}