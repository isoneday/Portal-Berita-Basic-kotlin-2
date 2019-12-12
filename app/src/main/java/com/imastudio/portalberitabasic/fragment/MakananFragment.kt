package com.imastudio.portalberitabasic.fragment


import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.imastudio.portalberitabasic.R
import com.imastudio.portalberitabasic.adapter.MakananAdapter
import com.imastudio.portalberitabasic.model.modelmakanan.ModelMakanan
import com.imastudio.portalberitabasic.network.InitRetrofit
import kotlinx.android.synthetic.main.fragment_makanan.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class MakananFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      var v =inflater.inflate(R.layout.fragment_makanan, container, false)
        getDataMakanan()

        return v
    }

    private fun getDataMakanan() {
        var loading = ProgressDialog.show(activity,"proses get data makanan","loading . . . .")

        var category = "seafood"
        InitRetrofit.getInstanceMakanan().getDataMakanan(category).enqueue(
            object : Callback<ModelMakanan> {

                override fun onFailure(call: Call<ModelMakanan>, t: Throwable) {
                    Log.d("cekerror","koneksi gagal \n error: ${t.localizedMessage}")
                    //untuk menghilangkan progress dialog
                    loading.dismiss()
                }

                override fun onResponse(call: Call<ModelMakanan>, response: Response<ModelMakanan>) {
                    //untuk menghilangkan progress dialog
                    loading.dismiss()
                    if (response.isSuccessful){
                        var status = response.code()
                        if (status==200){
                            var dataMakanan =response.body()?.meals
                            var adapter = MakananAdapter(activity,dataMakanan)
                            recyclermakanan.adapter= adapter
                            recyclermakanan.layoutManager= LinearLayoutManager(activity)
                        }
                    }
                }

            }
        )
    }


}
