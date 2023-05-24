package com.example.vmicalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class CalculationOUtput : AppCompatActivity() {

    lateinit var tvHeading:TextView
    lateinit var tvResult:TextView
    lateinit var tvTips: TextView
    lateinit var btnBack: Button
    lateinit var Resultcolor:LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculation_output)

        var bmiResult = intent.getStringExtra("bmi_result")?.toDouble()

        tvHeading= findViewById(R.id.tvheading)
        tvResult= findViewById(R.id.tvbmiResult)
        tvTips= findViewById(R.id.tvtips)
        btnBack= findViewById(R.id.btn_back)
        Resultcolor = findViewById(R.id.outputlayout)

        if (bmiResult!=null){
            if (bmiResult <= 18.4){
                tvHeading.text = "You are underweight"
                tvResult.text = "BMI is $bmiResult"
                tvTips.text = "Eat more and more food time to time and gain weight"
            }
            else if (bmiResult >= 18.5 && 24.9 >= bmiResult){
                tvHeading.text = "You are Normal"
                tvResult.text = "BMI is $bmiResult"
                tvTips.text = "You are fit and heath, you continue your routine"
                Resultcolor.setBackgroundColor(Color.parseColor("#40DD34"))
            }
            else if (bmiResult >= 25 ){
                tvHeading.text = "You are Overweight"
                tvResult.text = "BMI is $bmiResult"
                tvTips.text = "Ektu kom khaw and exericse koro"
            }
        }
        btnBack.setOnClickListener {
            finish()
        }

    }
}