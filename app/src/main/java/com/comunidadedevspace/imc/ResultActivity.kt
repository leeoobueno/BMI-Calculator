package com.comunidadedevspace.imc

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.content.ContextCompat


const val KEY_RESULT_IMC = "ResultActivityKEY_"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        window.statusBarColor = ContextCompat.getColor(this, R.color.primary_900)


        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)
        tvResult.text = result.toString()

        val color: Int
        val classificacao: String

        when {
            result < 18.5f -> {
                classificacao = "UNDERWEIGHT"
                color = ContextCompat.getColor(this, R.color.red)
            }

            result >= 18.5f && result <= 24.9f -> {
                classificacao = "NORMAL"
                color = ContextCompat.getColor(this, R.color.green)
            }

            result >= 25f && result <= 29.9f -> {
                classificacao = "OVERWEIGHT"
                color = ContextCompat.getColor(this, R.color.yellow)
            }

            result >= 30f && result <= 39.9f -> {
                classificacao = "OBESITY"
                color = ContextCompat.getColor(this, R.color.red)
            }

            else -> {
                classificacao = "MORBID OBESITY"
                color = ContextCompat.getColor(this, R.color.red)
            }
        }

        tvClassificacao.text = classificacao
        tvClassificacao.setTextColor(color)


    }
}