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
import com.imastudio.portalberitabasic.adapter.BeritaAdapter
import com.imastudio.portalberitabasic.model.modelberita.ModelBerita
import com.imastudio.portalberitabasic.network.InitRetrofit
import kotlinx.android.synthetic.main.fragment_berita.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class
BeritaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_berita, container, false)
        getDataBerita()

        return v
    }

    private fun getDataBerita() {
        var loading = ProgressDialog.show(activity,"proses get data berita","loading . . . .")

        var country = "id"
        var apikey ="9ba80533c8274efe96cb442df3512e5b"
        InitRetrofit.getInstance().getDataBerita(country, apikey).enqueue(
            object : Callback<ModelBerita> {
                override fun onFailure(call: Call<ModelBerita>, t: Throwable) {
                    Log.d("cekerror","koneksi gagal \n error: ${t.localizedMessage}")
                    //untuk menghilangkan progress dialog
                    loading.dismiss()
                }

                override fun onResponse(call: Call<ModelBerita>, response: Response<ModelBerita>) {
                    //untuk menghilangkan progress dialog
                    loading.dismiss()
                    if (response.isSuccessful){
                        var status = response.body()?.status
                        if (status.equals("ok")){
                            var dataArticle =response.body()?.articles
                            var adapter = BeritaAdapter(activity,dataArticle)
                            recyclerberita.adapter= adapter
                            recyclerberita.layoutManager= LinearLayoutManager(activity)
                        }
                    }
                }

            }
        )
    }


}
