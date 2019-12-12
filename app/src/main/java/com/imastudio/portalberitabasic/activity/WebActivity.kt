package com.imastudio.portalberitabasic.activity

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.imastudio.portalberitabasic.R
import com.imastudio.portalberitabasic.helper.BaseActivity.Companion.KEYWEB
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        web.webViewClient = WebViewClient()
        web.settings.javaScriptEnabled =true
        var a = intent.getStringExtra(KEYWEB)
        if (a!=null) web.loadUrl(a)
        else web.loadUrl("https://quran-offline.netlify.com/")
    }
}
