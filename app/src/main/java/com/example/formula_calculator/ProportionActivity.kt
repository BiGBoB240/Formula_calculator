package com.example.formula_calculator

import android.widget.EditText

class ProportionActivity : FormulaActivity() {
    override fun setupInputFields() {
        tvFormula.text = "a/b = c/d (find d)"
        inputContainer.addView(createInputField("Value a"))
        inputContainer.addView(createInputField("Value b"))
        inputContainer.addView(createInputField("Value c"))
        setupInputValidation(
            inputContainer.getChildAt(0) as EditText,
            inputContainer.getChildAt(1) as EditText,
            inputContainer.getChildAt(2) as EditText
        )
    }

    override fun calculate(): Double {
        val a = (inputContainer.getChildAt(0) as EditText).text.toString().toDouble()
        val b = (inputContainer.getChildAt(1) as EditText).text.toString().toDouble()
        val c = (inputContainer.getChildAt(2) as EditText).text.toString().toDouble()
        return c * b / a
    }
}