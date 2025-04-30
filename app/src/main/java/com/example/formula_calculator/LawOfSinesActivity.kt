package com.example.formula_calculator

import android.widget.EditText
import kotlin.math.sin
import kotlin.math.PI

class LawOfSinesActivity : FormulaActivity() {
    override fun setupInputFields() {
        tvFormula.text = "a/sin(A) = b/sin(B)"
        inputContainer.addView(createInputField("Side a"))
        inputContainer.addView(createInputField("Angle A (deg)"))
        inputContainer.addView(createInputField("Angle B (deg)"))
        setupInputValidation(
            inputContainer.getChildAt(0) as EditText,
            inputContainer.getChildAt(1) as EditText,
            inputContainer.getChildAt(2) as EditText
        )
    }

    override fun calculate(): Double {
        val a = (inputContainer.getChildAt(0) as EditText).text.toString().toDouble()
        val angleA = (inputContainer.getChildAt(1) as EditText).text.toString().toDouble()
        val angleB = (inputContainer.getChildAt(2) as EditText).text.toString().toDouble()
        return a * sin(angleB * PI / 180) / sin(angleA * PI / 180)
    }
}