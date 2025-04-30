package com.example.formula_calculator

import android.widget.EditText

class PercentageChangeActivity : FormulaActivity() {
    override fun setupInputFields() {
        tvFormula.text = "Percentage change"
        inputContainer.addView(createInputField("Original value"))
        inputContainer.addView(createInputField("New value"))
        setupInputValidation(
            inputContainer.getChildAt(0) as EditText,
            inputContainer.getChildAt(1) as EditText
        )
    }

    override fun calculate(): Double {
        val original = (inputContainer.getChildAt(0) as EditText).text.toString().toDouble()
        val new = (inputContainer.getChildAt(1) as EditText).text.toString().toDouble()
        return (new - original) / original * 100
    }
}