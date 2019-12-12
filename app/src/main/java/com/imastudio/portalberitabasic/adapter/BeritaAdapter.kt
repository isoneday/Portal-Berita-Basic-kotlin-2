package com.imastudio.portalberitabasic.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.imastudio.portalberitabasic.R
import com.imastudio.portalberitabasic.activity.DetailBeritaActivity
import com.imastudio.portalberitabasic.helper.BaseActivity.Companion.KEYBERITA
import com.imastudio.portalberitabasic.model.modelberita.ArticlesItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.tampilan.view.*

class BeritaAdapter(
    var beritaActivity: FragmentActivity?,
    var dataArticle: List<ArticlesItem?>?
) : RecyclerView.Adapter<BeritaAdapter.MyViewHolder>(){


    //untuk mengatur layout yang akan ditampilkan
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaAdapter.MyViewHolder {
    var view= LayoutInflater.from(beritaActivity).inflate(R.layout.tampilan,parent,false)
    return MyViewHolder(view)
    }

    //dklarasi dan inisialisasi
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    //untuk menghitung total data yang akan di load/tampil
    override fun getItemCount(): Int = dataArticle?.size!!

    //untuk menset atau mengisi data
    override fun onBindViewHolder(holder: BeritaAdapter.MyViewHolder, position: Int) {
    holder.itemView.txtnamaaplikasi.text = dataArticle?.get(position)?.title
        Picasso.get().load(dataArticle?.get(position)?.urlToImage)
            .placeholder(R.drawable.berita).error(R.drawable.berita).into(holder.itemView.imgaplikasi)
        //aksi klik
        holder.itemView.setOnClickListener {
            var intent = Intent(beritaActivity,DetailBeritaActivity::class.java)
            intent.putExtra(KEYBERITA,dataArticle?.get(position))

            beritaActivity?.startActivity(intent)
        }
    }
}