package com.imastudio.portalberitabasic.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.imastudio.portalberitabasic.R
import kotlinx.android.synthetic.main.fragment_awal.view.*

/**
 * A simple [Fragment] subclass.
 */
class AwalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_awal, container, false)
        v.btnmakanan.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container,MakananFragment())?.commit()

        }
        v.btnberita.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.container,BeritaFragment())?.commit()

        }
        return v
    }


}
