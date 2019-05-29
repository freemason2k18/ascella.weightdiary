package com.ascellapp.weightdiary.BMIcalculator

fun bodyMassIndex() {

    val height = 1.7 // meters
    val weight = 80 // kilograms

    println("Height: $height meters")
    println("Weight: $weight kg")
    println()

    val bmi = weight / (height * height)
    println("BMI = %.3f".format(bmi))

    if(bmi < 25)
        print("Normal.")
    else if (bmi <= 29)
        print("Overweight.")
    else
        print("Obese!")
}