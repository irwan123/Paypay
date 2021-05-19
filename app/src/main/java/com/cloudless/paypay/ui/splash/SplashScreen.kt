package com.cloudless.paypay.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.cloudless.paypay.R
import com.cloudless.paypay.databinding.ActivitySplashScreenBinding
import com.cloudless.paypay.ui.login.LoginActivity

class SplashScreen : AppCompatActivity() {
    private lateinit var binding : ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        val bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        binding.tvMiddle.startAnimation(topAnimation)
        binding.tvMiddle2.startAnimation(bottomAnimation)
        val splashScreenTimeOut = 4000
        val intent = Intent(this, LoginActivity::class.java)
        Handler().postDelayed({
            startActivity(intent)
            finish()
        }, splashScreenTimeOut.toLong())
    }
}