package com.ascellapp.weightdiary.BMIcalculator

interface BMI_view {

    val height = heightInput.text.toString().toFloat()
    val weight = weightInput.text.toString().toFloat()

    val bmi = BMIFormula().getBodyMassIndex(weight, height) // weight / (height * height)

    resultText.text = bmi.toString()
}