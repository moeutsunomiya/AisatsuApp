package com.example.aisatsuapp

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
    }

    override fun onClick(v:View){
        if(v.id == R.id.button1){
            showTimePickerDialog()
        }else{
            Log.d("AisatsuApp", "処理なし")
        }
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                chengeTextOfTime(hour)
                Log.d("AisatsuApp", "$hour:$minute")
            },
            13, 0, true
        )
        timePickerDialog.show()

    }
    private fun chengeTextOfTime(hour:Int){
        if (2 <= hour &&  hour < 10){
            textview1.text = "おはよう"
            Log.d("AisatsuApp", "おはよう")

        }else if (10 <= hour && hour < 18) {
            textview1.text = "こんにちは"
            Log.d("AisatsuApp", "こんにちは")

        }else if ( (18<= hour && hour <= 23) || (0 <= hour && hour < 2)) {
            textview1.text = "こんばんは"
            Log.d("AisatsuApp", "こんばんは")
        }else{
            textview1.text = "もう一度時刻を設定してください"
            Log.d("AisatsuApp", "エラー")
        }
    }
}


