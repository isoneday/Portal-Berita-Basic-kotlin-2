package com.imastudio.portalberitabasic.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.imastudio.portalberitabasic.R
import com.imastudio.portalberitabasic.activity.DetailMakananActivity
import com.imastudio.portalberitabasic.helper.BaseActivity.Companion.KEYMAKANAN
import com.imastudio.portalberitabasic.model.modelmakanan.MealsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.tampilan.view.*

class MakananAdapter(
    var makananActivity: FragmentActivity?,
    var dataMakanan: List<MealsItem?>?
) : RecyclerView.Adapter<MakananAdapter.MyViewHolder>(){


    //untuk mengatur layout yang akan ditampilkan
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakananAdapter.MyViewHolder {
    var view= LayoutInflater.from(makananActivity).inflate(R.layout.tampilan,parent,false)
    return MakananAdapter.MyViewHolder(view)
    }

    //dklarasi dan inisialisasi
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    //untuk menghitung total data yang akan di load/tampil
    override fun getItemCount(): Int = dataMakanan?.size!!

    //untuk menset atau mengisi data
    override fun onBindViewHolder(holder: MakananAdapter.MyViewHolder, position: Int) {
    holder.itemView.txtnamaaplikasi.text = dataMakanan?.get(position)?.strMeal
        Picasso.get().load(dataMakanan?.get(position)?.strMealThumb)
            .placeholder(R.drawable.berita).error(R.drawable.berita).into(holder.itemView.imgaplikasi)
        //aksi klik
        holder.itemView.setOnClickListener {
            var intent = Intent(makananActivity, DetailMakananActivity::class.java)
            intent.putExtra(KEYMAKANAN,dataMakanan?.get(position))

            makananActivity?.startActivity(intent)
        }
    }
}