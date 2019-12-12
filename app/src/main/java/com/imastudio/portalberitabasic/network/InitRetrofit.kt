package com.imastudio.portalberitabasic.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object InitRetrofit {

    val BASE_URLAUTH ="http://192.168.60.136/basickotlin/"
    val BASE_URLBERITA ="https://newsapi.org/v2/"
    val BASE_URLMAKANAN ="https://www.themealdb.com/api/json/v1/1/"
    var MAPURL ="https://maps.googleapis.com/maps/api/place/"
    val BASE_URLMAPMASJID ="${MAPURL}nearbysearch/"

    val IMAGE_URL =MAPURL
    const val KEYBERITA = "data"

    val interceptor = HttpLoggingInterceptor().
        setLevel(HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .retryOnConnectionFailure(true)
        .connectTimeout(15,TimeUnit.SECONDS)
        .build()
    val gson = GsonBuilder().setLenient().create()
//api berita
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URLBERITA)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun getInstance() : RestApi = retrofit.create(RestApi::class.java)

    //api makanan
   val retrofitMakanan = Retrofit.Builder()
        .baseUrl(BASE_URLMAKANAN)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun getInstanceMakanan() : RestApi = retrofitMakanan.create(RestApi::class.java)

    val retrofitAuth = Retrofit.Builder()
        .baseUrl(BASE_URLAUTH)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun getInstanceAuth() : RestApi = retrofitAuth.create(RestApi::class.java)

    val retrofitmapMasjid = Retrofit.Builder()
        .baseUrl(BASE_URLMAPMASJID)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun getInstanceMapMasjid() : RestApi = retrofitmapMasjid.create(RestApi::class.java)



}