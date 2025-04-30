package com.example.formula_calculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.formula_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCircleArea.setOnClickListener { launchFormulaActivity(CircleAreaActivity::class.java) }
        binding.btnPythagoras.setOnClickListener { launchFormulaActivity(PythagorasTheoremActivity::class.java) }
        binding.btnSines.setOnClickListener { launchFormulaActivity(LawOfSinesActivity::class.java) }
        binding.btnCosines.setOnClickListener { launchFormulaActivity(LawOfCosinesActivity::class.java) }


    }


    private fun launchFormulaActivity(activityClass: Class<*>) {
        startActivity(Intent(this, activityClass))
    }
}