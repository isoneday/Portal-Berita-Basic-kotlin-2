package com.imastudio.portalberitabasic.activity

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.imastudio.portalberitabasic.R
import com.imastudio.portalberitabasic.adapter.BeritaAdapter
import com.imastudio.portalberitabasic.helper.BaseActivity
import com.imastudio.portalberitabasic.model.modelberita.ModelBerita
import com.imastudio.portalberitabasic.network.InitRetrofit
import kotlinx.android.synthetic.main.activity_berita.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BeritaActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita)

        getDataBerita()
    }

    private fun getDataBerita() {
        var loading = ProgressDialog.show(this,"proses get data berita","loading . . . .")

        var country = "id"
        var apikey ="9ba80533c8274efe96cb442df3512e5b"
        InitRetrofit.getInstance().getDataBerita(country, apikey).enqueue(
            object : Callback<ModelBerita>{
                override fun onFailure(call: Call<ModelBerita>, t: Throwable) {
                tampilToast("koneksi gagal \n error: ${t.localizedMessage}")
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
                            var adapter = BeritaAdapter(this@BeritaActivity,dataArticle)
                            recyclerberita.adapter= adapter
                            recyclerberita.layoutManager=LinearLayoutManager(this@BeritaActivity)
                        }
                    }
                }

            }
        )
    }

}
