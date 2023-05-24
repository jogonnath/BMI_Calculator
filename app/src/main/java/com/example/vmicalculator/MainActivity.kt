package com.example.vmicalculator

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var btnMale:LinearLayout
    lateinit var btnFemale:LinearLayout
    lateinit var btnHeight:TextView
    lateinit var btnSeekbar: SeekBar
    lateinit var tvAge:TextView
    lateinit var tvWeight:TextView
    lateinit var btnWeightPlus:ImageView
    lateinit var btnWeightMinus:ImageView
    lateinit var btnAgePlus:ImageView
    lateinit var btnAgeMinus:ImageView

    lateinit var btnCalculate:LinearLayout


    var weight= 0
    var age=0
    var height=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMale = findViewById(R.id.btnmaleid)
        btnFemale = findViewById(R.id.btnfemaleid)
        btnHeight = findViewById(R.id.textheight)
        btnSeekbar = findViewById(R.id.seekbar)
        tvAge = findViewById(R.id.text_age)
        tvWeight = findViewById(R.id.text_weight)
        btnWeightPlus = findViewById(R.id.btnweightplus)
        btnWeightMinus = findViewById(R.id.btn_weightromove)
        btnAgePlus = findViewById(R.id.btn_age_plus)
        btnAgeMinus = findViewById(R.id.btn_age_remove)
        btnCalculate= findViewById(R.id.btn_calculate)


        btnMale.setOnClickListener {
            btnMale.setBackgroundColor(Color.parseColor("#6782B1"))
            btnFemale.setBackgroundColor(Color.parseColor("#636E81"))
        }
        btnFemale.setOnClickListener {
            btnFemale.setBackgroundColor(Color.parseColor("#6782B1"))
            btnMale.setBackgroundColor(Color.parseColor("#636E81"))
        }

        btnSeekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                height=progress
                btnHeight.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        btnWeightPlus.setOnClickListener {
            weight++
            tvWeight.text= weight.toString()
        }
        btnWeightMinus.setOnClickListener {
            if (1<weight) weight--
            tvWeight.text=weight.toString()
        }

        btnAgePlus.setOnClickListener {
            age++
            tvAge.text=age.toString()
        }
        btnAgeMinus.setOnClickListener {
            if (1<age) age--
            tvAge.text=age.toString()
        }
        btnCalculate.setOnClickListener {
            bmiCalculation(height,weight)
        }


    }

    fun bmiCalculation(height: Int, weight: Int){
        var mheight = Math.pow((height*0.01).toDouble(), 2.toDouble())
        var bmi = weight/mheight
//        Toast.makeText(this, String.format("%.2f",bmi), Toast.LENGTH_SHORT).show()
//        startActivity(Intent(this, CalculationOUtput::class.java))

        val intent=Intent(this,CalculationOUtput::class.java)
        intent.putExtra("bmi_result", String.format("%.2f", bmi))
        startActivity(intent)
    }
}