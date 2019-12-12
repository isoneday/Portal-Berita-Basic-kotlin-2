package com.imastudio.portalberitabasic.helper

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    var c: Context = this

    fun pindahHalaman(kelasTujuan: Class<*>) = startActivity(Intent(c, kelasTujuan))

    fun tampilToast(isiPesan: String) = Toast.makeText(c, isiPesan, Toast.LENGTH_SHORT).show()
    companion object{
        const val KEYBERITA ="berita"
        const val KEYMAKANAN ="makanan"
        const val KEYWEB ="asda"
    }
}