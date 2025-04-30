package com.example.formula_calculator

import android.widget.EditText
import com.example.formula_calculator.FormulaActivity  // Убедитесь, что FormulaActivity существует

class CircleAreaActivity : FormulaActivity() {
    // Убедитесь, что в FormulaActivity эти методы объявлены как abstract
    override fun setupInputFields() {
        // Эти поля должны быть объявлены в FormulaActivity
        tvFormula.text = "S = π × r²"
        inputContainer.addView(createInputField("Радиус (r)"))
        setupInputValidation(inputContainer.getChildAt(0) as EditText)
    }

    override fun calculate(): Double {
        val radius = (inputContainer.getChildAt(0) as EditText).text.toString().toDouble()
        return Math.PI * radius * radius
    }
}