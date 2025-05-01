package com.example.formula_calculator

import android.widget.EditText
import com.example.formula_calculator.FormulaActivity 

class CircleAreaActivity : FormulaActivity() {
    
    override fun setupInputFields() {
        
        tvFormula.text = "S = π × r²"
        inputContainer.addView(createInputField("Radius (r)"))
        setupInputValidation(inputContainer.getChildAt(0) as EditText)
    }

    override fun calculate(): Double {
        val radius = (inputContainer.getChildAt(0) as EditText).text.toString().toDouble()
        return Math.PI * radius * radius
    }
}
