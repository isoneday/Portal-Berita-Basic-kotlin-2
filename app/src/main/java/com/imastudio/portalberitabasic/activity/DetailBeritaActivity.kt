package com.imastudio.portalberitabasic.activity

import android.content.Intent
import android.os.Bundle
import com.imastudio.portalberitabasic.R
import com.imastudio.portalberitabasic.helper.BaseActivity
import com.imastudio.portalberitabasic.model.modelberita.ArticlesItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_berita.*
import kotlinx.android.synthetic.main.content_detail_berita.*

class DetailBeritaActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_berita)
        setSupportActionBar(toolbar)
        var databerita = intent.getParcelableExtra<ArticlesItem>(KEYBERITA)

        fab.setOnClickListener { view ->
            //            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
            var webbuah = databerita.url
            var intent = Intent(
                this,
                WebActivity::class.java
            )
            intent.putExtra(KEYWEB, webbuah)
            startActivity(intent)
        }

        Picasso.get().load(databerita.urlToImage)
            .placeholder(R.drawable.berita).error(R.drawable.berita).into(imgdetailberita)

        txttitle.text = databerita.title
        var titlebar = supportActionBar
        titlebar?.title = databerita.title

        txtdetail.text =databerita.description


    }
}
