package com.ascellapp.weightdiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.ascellapp.weightdiary.BMIcalculator.BMI_view
import com.ascellapp.weightdiary.util.BMIformula

class bmicaluclator : AppCompatActivity(), BMI_view {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bmi_calculator_layout)

        val heightInput: EditText = findViewById(R.id.input_height)
        val weightInput: EditText = findViewById(R.id.input_weight)

        val resultText: TextView = findViewById(R.id.text_result)

        val calculateButton: Button = findViewById(R.id.btn_calculate)
        calculateButton.setOnClickListener { view ->

            //            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()

            // presenter.onCalculateClicked(heightInput.text, weightInput.text)


            //resultText.text = "123"

            val height = heightInput.text.toString().toFloat()
            val weight = weightInput.text.toString().toFloat()

            val bmi = BMIformula().getBodyMassIndex(weight, height) // weight / (height * height)

            resultText.text = bmi.toString()
        }
    }

    fun showWeightNormal() {
        warningText.text = "Normal"
    }


    fun showOverweightWarning() {
        warningText.text = "Overweight"
    }


    // это метод в презентере
    fun onCalculateClicked(weight: String, height: String) {
        val w = weight.toString().toFloat()
        val h = height.toString().toFloat()

        val bmi = BMIformula().getBodyMassIndex(w, h) // weight / (height * height)

        view.showBMI(bmi)

        if(bmi < 25)
            view.showWeightNormal()
        else if (bmi <= 29)
            view.showOverweightWarning()
        else {
            view.showObesWarning()
        }

    }
}
