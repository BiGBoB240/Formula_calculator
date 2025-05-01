package com.example.formula_calculator

import android.os.Bundle
import android.text.InputType
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

abstract class FormulaActivity : AppCompatActivity() {
    
    protected lateinit var tvFormula: TextView
    protected lateinit var inputContainer: LinearLayout
    protected lateinit var tvResult: TextView
    protected lateinit var btnCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formula)

        
        tvFormula = findViewById(R.id.tvFormula)
        inputContainer = findViewById(R.id.inputContainer)
        tvResult = findViewById(R.id.tvResult)
        btnCalculate = findViewById(R.id.btnCalculate)

        setupInputFields()
        setupCalculateButton()
    }

    abstract fun setupInputFields()
    abstract fun calculate(): Double

    protected fun createInputField(hint: String): EditText {
        return EditText(this).apply {
            this.hint = hint
            inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                bottomMargin = 16.dpToPx()
            }
        }
    }

    protected fun setupInputValidation(vararg fields: EditText) {
        fields.forEach { field ->
            field.addTextChangedListener {
                tvResult.text = ""
            }
        }
    }

    private fun Int.dpToPx(): Int = (this * resources.displayMetrics.density).toInt()

    private fun setupCalculateButton() {
        btnCalculate.setOnClickListener {
            if (validateInputs()) {
                val result = calculate()
                tvResult.text = "Result: %.2f".format(result)
            } else {
                Toast.makeText(this, "Fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    protected open fun validateInputs(): Boolean = true
}
