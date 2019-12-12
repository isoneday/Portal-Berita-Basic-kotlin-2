package com.imastudio.portalberitabasic.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.imastudio.portalberitabasic.R
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        //animasi lottie
        lottie.setAnimation("walking.json")
        lottie.loop(true)
        lottie.playAnimation()

        //untuk melakukan penundaan perpindahan halaman
        var h = Handler()
        h.postDelayed(Runnable {
            //perpindahan halaman
            startActivity(Intent(this@SplashScreenActivity
                , HomeActivity::class.java))
            //mengkill atau mengakhiri suatu halaman didalam stack activity
            finish()
        },3000)
    }
}





