package com.imastudio.portalberitabasic.network

import com.imastudio.portalberitabasic.model.modelberita.ModelBerita
import com.imastudio.portalberitabasic.model.modeldetailmakanan.ModelDetailMakanan
import com.imastudio.portalberitabasic.model.modelmakanan.ModelMakanan
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    @GET("top-headlines")
    fun getDataBerita(
        @Query("country") country: String?,
        @Query("apiKey") apikey: String?
    ): Call<ModelBerita>


    @GET("filter.php")
    fun getDataMakanan(
        @Query("c") category: String?

    ): Call<ModelMakanan>

    @GET("lookup.php")
    fun getDetailMakanan(
        @Query("i") index: String?

    ): Call<ModelDetailMakanan>


}