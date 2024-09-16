package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
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


            val weightStr: String = edtWeight.text.toString()
            val heightStr: String = edtHeight.text.toString()

            if (weightStr == "" || heightStr == "") {
                // Mostrar mensagem para o usuario

                Snackbar.make(
                    edtWeight,
                    "Fill in all the fields",
                    Snackbar.LENGTH_LONG
                ).show()



            } else {
                val weight = weightStr.toFloat()
                val height = heightStr.toFloat()

                val heightQ2 = height * height
                val result = weight / heightQ2

                println("Leonardo " + result)
            }
        }
    }
}