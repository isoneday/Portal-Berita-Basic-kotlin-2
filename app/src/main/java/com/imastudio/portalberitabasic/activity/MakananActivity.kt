package com.imastudio.portalberitabasic.activity

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.imastudio.portalberitabasic.R
import com.imastudio.portalberitabasic.adapter.MakananAdapter
import com.imastudio.portalberitabasic.helper.BaseActivity
import com.imastudio.portalberitabasic.model.modelmakanan.ModelMakanan
import com.imastudio.portalberitabasic.network.InitRetrofit
import kotlinx.android.synthetic.main.activity_makanan.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MakananActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_makanan)

        getDataMakanan()
    }

    private fun getDataMakanan() {
        var loading = ProgressDialog.show(this,"proses get data makanan","loading . . . .")

        var category = "seafood"
        InitRetrofit.getInstanceMakanan().getDataMakanan(category).enqueue(
            object : Callback<ModelMakanan>{

                override fun onFailure(call: Call<ModelMakanan>, t: Throwable) {
                tampilToast("koneksi gagal \n error: ${t.localizedMessage}")
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
                            var adapter = MakananAdapter(this@MakananActivity,dataMakanan)
                            recyclermakanan.adapter= adapter
                            recyclermakanan.layoutManager=LinearLayoutManager(this@MakananActivity)
                        }
                    }
                }

            }
        )
    }

}
