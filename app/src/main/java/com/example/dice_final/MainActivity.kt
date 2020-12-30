package com.example.dice_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import java.util.*
import kotlin.random.Random as Random1

class MainActivity : AppCompatActivity() {
    private lateinit var imgDice:ImageView
    private val diceImages = mutableListOf<Int>()
    private lateinit var animation:Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imgDice = findViewById(R.id.imgDice)
        val btnRoll = findViewById<Button>(R.id.btnRoll)
        btnRoll.setOnClickListener {

            getRandomValue()
        }

        diceImages.add(R.drawable.ic_dice_one)
        diceImages.add(R.drawable.ic_dice_two)
        diceImages.add(R.drawable.ic_dice_three)
        diceImages.add(R.drawable.ic_dice_four)
        diceImages.add(R.drawable.ic_dice_five)
        diceImages.add(R.drawable.ic_dice_six)

        animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.shake_anim)
    }

    private fun getRandomValue() {
        val random = Random().nextInt(6)

        imgDice.startAnimation(animation)
        animation.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                imgDice.setImageResource(diceImages.elementAt(random))

            }

            override fun onAnimationRepeat(animation: Animation?) {
                imgDice.setImageResource(R.drawable.ic_dice)
            }

        })

    }
}