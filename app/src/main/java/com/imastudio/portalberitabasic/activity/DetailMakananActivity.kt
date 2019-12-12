package com.imastudio.portalberitabasic.activity

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.imastudio.portalberitabasic.R
import com.imastudio.portalberitabasic.helper.BaseActivity

import com.imastudio.portalberitabasic.model.modeldetailmakanan.ModelDetailMakanan
import com.imastudio.portalberitabasic.model.modelmakanan.MealsItem
import com.imastudio.portalberitabasic.network.InitRetrofit
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_makanan.*
import kotlinx.android.synthetic.main.content_detail_makanan.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailMakananActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_makanan)
        setSupportActionBar(toolbar)
        var dataMakanan = intent.getParcelableExtra<MealsItem>(KEYMAKANAN)
        var index = dataMakanan.idMeal
        getdetailMakanan(index)


    }

    private fun getdetailMakanan(index: String?) {
        var loading = ProgressDialog.show(this, "proses get detail makanan", "loading . . . .")

        InitRetrofit.getInstanceMakanan().getDetailMakanan(index).enqueue(
            object : Callback<ModelDetailMakanan> {
                override fun onFailure(call: Call<ModelDetailMakanan>, t: Throwable) {
                    tampilToast("koneksi gagal \n error: ${t.localizedMessage}")
                    Log.d("cekerror", "koneksi gagal \n error: ${t.localizedMessage}")
                    //untuk menghilangkan progress dialog
                    loading.dismiss()
                }

                override fun onResponse(
                    call: Call<ModelDetailMakanan>,
                    response: Response<ModelDetailMakanan>
                ) {
                    //untuk menghilangkan progress dialog
                    loading.dismiss()
                    if (response.isSuccessful) {
                        var status = response.code()
                        if (status == 200) {
                            var detailMakanan = response.body()?.meals

                            Picasso.get().load(detailMakanan?.get(0)?.strMealThumb)
                                .placeholder(R.drawable.berita).error(R.drawable.berita)
                                .into(imgdetailberita)

                            txttitle.text = detailMakanan?.get(0)?.strMeal
                            var titlebar = supportActionBar
                            titlebar?.title = detailMakanan?.get(0)?.strMeal

                            txtdetail.text = detailMakanan?.get(0)?.strInstructions
                            fab.setOnClickListener { view ->
                                //            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
                                var webbuah = detailMakanan?.get(0)?.strYoutube
                                var intent = Intent(
                                    this@DetailMakananActivity,
                                    WebActivity::class.java
                                )
                                intent.putExtra(KEYWEB, webbuah)
                                startActivity(intent)
                            }

                        }
                    }
                }

            }
        )
    }
}
