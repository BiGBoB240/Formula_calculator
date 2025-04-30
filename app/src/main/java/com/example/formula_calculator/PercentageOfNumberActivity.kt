package com.example.formula_calculator

import android.widget.EditText

class PercentageOfNumberActivity : FormulaActivity() {
    override fun setupInputFields() {
        tvFormula.text = "What is X% of Y?"
        inputContainer.addView(createInputField("Percentage (X)"))
        inputContainer.addView(createInputField("Number (Y)"))
        setupInputValidation(
            inputContainer.getChildAt(0) as EditText,
            inputContainer.getChildAt(1) as EditText
        )
    }

    override fun calculate(): Double {
        val x = (inputContainer.getChildAt(0) as EditText).text.toString().toDouble()
        val y = (inputContainer.getChildAt(1) as EditText).text.toString().toDouble()
        return x * y / 100
    }
}