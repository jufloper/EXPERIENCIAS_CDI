package com.loma.experienciascdi


import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat


class Experiencias : AppCompatActivity() {


    private var btnGabriela: ImageButton? = null
    private var btnEmiliana: ImageButton? = null
    private var btnSami: ImageButton? = null
    private var btnEmanuel: ImageButton? = null
    private var btnIsaac: ImageButton? = null
    private var gabriela: ImageButton? = null
    private var emiliana: ImageButton? = null
    private var sami: ImageButton? = null
    private var emanuel: ImageButton? = null
    private var isaac: ImageButton? = null
    private var gotoStart:ImageButton? = null



    private var animFow: Animation? = null
    private var animBack: Animation? = null


    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_experiencias)
        hideSystemUI()

        gotoStart = findViewById(R.id.btn_start)

        //faces n names buttons
        btnGabriela = findViewById(R.id.btn_gabriela)
        btnEmiliana = findViewById(R.id.btn_emiliana)
        btnSami= findViewById(R.id.btn_sami)
        btnEmanuel = findViewById(R.id.btn_emanuel)
        btnIsaac = findViewById(R.id.btn_isaac)
        gabriela = findViewById(R.id.gabriela)
        emiliana = findViewById(R.id.emiliana)
        sami= findViewById(R.id.sami)
        emanuel = findViewById(R.id.emanuel)
        isaac = findViewById(R.id.isaac)


    //declaracion de animaciones
        animFow= AnimationUtils.loadAnimation(this, R.anim.rotate_foward)
        animBack = AnimationUtils.loadAnimation(this, R.anim.rotate_backwards)




        //onclick listener botones
        btnGabriela?.setOnClickListener {
            showModal(1)
        }
        btnEmanuel?.setOnClickListener {
            showModal(2)
        }
        btnEmiliana?.setOnClickListener {
            showModal(3)
        }
        btnSami?.setOnClickListener {
            showModal(4)
        }
        btnIsaac?.setOnClickListener {
            showModal(5)
        }

        //onclick listener faces
        gabriela?.setOnClickListener {
            showModal(1)
        }
        emanuel?.setOnClickListener {
            showModal(2)
        }
        emiliana?.setOnClickListener {
            showModal(3)
        }
        sami?.setOnClickListener {
            showModal(4)
        }
        isaac?.setOnClickListener {
            showModal(5)
        }

        gotoStart?.setOnClickListener {
            finish()
        }

    }

    @RequiresApi(Build.VERSION_CODES.R)
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

    override fun onBackPressed() {

    }
    @RequiresApi(Build.VERSION_CODES.R)
    fun showModal(pelaito:Int){

        val view =View.inflate(this@Experiencias, R.layout.modal_resource, null)
        val builder = AlertDialog.Builder(this@Experiencias)
        builder.setView(view)
        val dialog = builder.create()
        dialog.show()
        hideSystemUI()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)

        val externalCircle : ImageView = view.findViewById(R.id.play_circle)
        val middleCircle : ImageView = view.findViewById(R.id.play_circle2)
        val innerCircle : ImageView = view.findViewById(R.id.play_circle3)

        val playButton : ImageButton = view.findViewById(R.id.play_button)
        val stopButton : ImageButton = view.findViewById(R.id.stop_button)
        val kidImage : ImageView= view.findViewById(R.id.kid_image)
        val kidName : ImageView= view.findViewById(R.id.name)
        var mediaPlayer = MediaPlayer.create(this, R.raw.startsrc)


        when(pelaito){
            1->{
                mediaPlayer = MediaPlayer.create(this, R.raw.gabriela)
                kidImage.setImageResource(R.drawable.gabriela)
                kidName.setImageResource(R.drawable.gabriela_color)
                mediaPlayer.start()
            }
            2->{
                mediaPlayer = MediaPlayer.create(this, R.raw.emanuel)
                kidImage.setImageResource(R.drawable.emanuel)
                kidName.setImageResource(R.drawable.emanuel_color)
                mediaPlayer.start()
            }
            3->{
                mediaPlayer = MediaPlayer.create(this, R.raw.emiliana)
                kidImage.setImageResource(R.drawable.emiliana)
                kidName.setImageResource(R.drawable.emiliana_color)
                mediaPlayer.start()
            }
            4->{
                mediaPlayer = MediaPlayer.create(this, R.raw.sami)
                kidImage.setImageResource(R.drawable.sami)
                kidName.setImageResource(R.drawable.sami_color)
                mediaPlayer.start()
            }
            5->{
                mediaPlayer = MediaPlayer.create(this, R.raw.isaac)
                kidImage.setImageResource(R.drawable.isaac)
                kidName.setImageResource(R.drawable.isaac_color)
                mediaPlayer.start()
            }


        }



        externalCircle.startAnimation(animFow)
        middleCircle.startAnimation(animBack)
        innerCircle.startAnimation(animFow)

        playButton.setOnClickListener {
            if (mediaPlayer.isPlaying){
                mediaPlayer.pause()
                externalCircle.clearAnimation()
                middleCircle.clearAnimation()
                innerCircle.clearAnimation()
                playButton.setImageResource(R.drawable.boton_play)
            }else{
                mediaPlayer.start()
                externalCircle.startAnimation(animFow)
                middleCircle.startAnimation(animBack)
                innerCircle.startAnimation(animFow)
                playButton.setImageResource(R.drawable.boton_pause)

            }
        }
        stopButton.setOnClickListener {
            if (mediaPlayer.isPlaying){
                mediaPlayer.pause()
                mediaPlayer.reset()
                dialog.dismiss()
                hideSystemUI()
            }

            dialog.dismiss()


        }
        mediaPlayer.setOnCompletionListener{
            externalCircle.clearAnimation()
            middleCircle.clearAnimation()
            innerCircle.clearAnimation()
            playButton.setImageResource(R.drawable.boton_play)
            hideSystemUI()
        }




    }





}