package com.example.formula_calculator

import android.widget.EditText
import kotlin.math.cos
import kotlin.math.sqrt
import kotlin.math.PI

class LawOfCosinesActivity : FormulaActivity() {
    override fun setupInputFields() {
        tvFormula.text = "c² = a² + b² - 2ab·cos(C)"
        inputContainer.addView(createInputField("Side a"))
        inputContainer.addView(createInputField("Side b"))
        inputContainer.addView(createInputField("Angle C (deg)"))
        setupInputValidation(
            inputContainer.getChildAt(0) as EditText,
            inputContainer.getChildAt(1) as EditText,
            inputContainer.getChildAt(2) as EditText
        )
    }

    override fun calculate(): Double {
        val a = (inputContainer.getChildAt(0) as EditText).text.toString().toDouble()
        val b = (inputContainer.getChildAt(1) as EditText).text.toString().toDouble()
        val angleC = (inputContainer.getChildAt(2) as EditText).text.toString().toDouble()
        return sqrt(a * a + b * b - 2 * a * b * cos(angleC * PI / 180))
    }
}