package com.imastudio.portalberitabasic.activity

import android.os.Bundle
import android.view.View
import com.imastudio.portalberitabasic.R
import com.imastudio.portalberitabasic.helper.BaseActivity

class MenuActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

    }

    fun onBerita(view: View) {
        pindahHalaman(BeritaActivity::class.java)
    }

    fun onMakanan(view: View) {
        pindahHalaman(MakananActivity::class.java)

    }
}
