package com.example.formula_calculator

import android.widget.EditText
import kotlin.math.sqrt

class PythagorasTheoremActivity : FormulaActivity() {
    override fun setupInputFields() {
        tvFormula.text = "c = √(a² + b²)"
        inputContainer.addView(createInputField("Leg (a)"))
        inputContainer.addView(createInputField("Leg (b)"))
        setupInputValidation(
            inputContainer.getChildAt(0) as EditText,
            inputContainer.getChildAt(1) as EditText
        )
    }

    override fun calculate(): Double {
        val a = (inputContainer.getChildAt(0) as EditText).text.toString().toDouble()
        val b = (inputContainer.getChildAt(1) as EditText).text.toString().toDouble()
        return sqrt(a * a + b * b)
    }
}