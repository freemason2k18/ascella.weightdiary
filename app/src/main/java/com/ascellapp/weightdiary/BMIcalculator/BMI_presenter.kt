package com.ascellapp.weightdiary.BMIcalculator

class BMI_presenter {

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


