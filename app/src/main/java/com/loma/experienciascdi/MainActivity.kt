package com.loma.experienciascdi

import android.content.Intent
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat



class MainActivity : AppCompatActivity() {

    private var imageButton: ImageButton? = null

    private var circleTop: ImageView? = null
    private var circleShadowTop: ImageView? = null
    private var animationF: Animation? = null
    private var animationB: Animation? = null
    private var blinkAnimation: Animation? = null
    private var fadeoutAnimation: Animation? = null
    private var circleBottom: ImageView? = null
    private var clickImage: ImageView? = null



    @RequiresApi(VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // A function to hide NavigationBar
        hideSystemUI()
        circleBottom = findViewById(R.id.circlebottom)

        circleTop = findViewById(R.id.circletop)
        circleShadowTop = findViewById(R.id.circleshadowtop)
        clickImage =findViewById(R.id.click_image)
        imageButton = findViewById(R.id.btn_ingreso)


        animationF = AnimationUtils.loadAnimation(this, R.anim.rotate_foward)
        animationB = AnimationUtils.loadAnimation(this, R.anim.rotate_backwards)
        blinkAnimation = AnimationUtils.loadAnimation(this, R.anim.blink)
        fadeoutAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_out)

        circleBottom?.startAnimation(animationF)
        circleTop?.startAnimation(animationB)
        circleShadowTop?.startAnimation(animationB)
        clickImage?.startAnimation(blinkAnimation)


        imageButton?.setOnClickListener {
            val intent = Intent(this@MainActivity, Experiencias::class.java)
            startActivity(intent)
        }



    }


    // Function to hide NavigationBar
    @RequiresApi(VERSION_CODES.R)
    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window,
            window.decorView.findViewById(android.R.id.content)).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())

            // When the screen is swiped up at the bottom
            // of the application, the navigationBar shall
            // appear for some time
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }
    @RequiresApi(VERSION_CODES.R)
    override fun onResume(){
        super.onResume()
        hideSystemUI()
    }


}