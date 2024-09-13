package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Recuperar os componentes EditText
        // Criar uma variavel e associar o componente de UI <EditText>
        // Recuperar o botao da tela
        // Colocar a acao do botao
        // Recuperar o texto digitado no edt peso

        val edtWeight = findViewById<TextInputEditText>(R.id.edt_weight)
        val edtHeight = findViewById<TextInputEditText>(R.id.edt_height)
        val btnCalculate = findViewById<Button>(R.id.btn_calculate)

        btnCalculate.setOnClickListener {
            val weight : Float = edtWeight.text.toString().toFloat()
            val height : Float = edtHeight.text.toString().toFloat()

            val heightQ2 = height * height
            val result = weight / heightQ2

            println(result)

        }
    }
}