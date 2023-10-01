package com.example.practicacalificada01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var ntParcialEditText: EditText
    private lateinit var ntFinalEditText: EditText
    private lateinit var notaPEPEditText: EditText
    private lateinit var calculateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ntParcialEditText = findViewById(R.id.ntParcial)
        ntFinalEditText = findViewById(R.id.ntFinal)
        notaPEPEditText = findViewById(R.id.notaPEP)
        calculateButton = findViewById(R.id.btnCalcular)

        calculateButton.setOnClickListener {
            calculateAndShowResult()
        }
    }

    private fun calculateAndShowResult() {
        val ntParcial = ntParcialEditText.text.toString().toDoubleOrNull()
        val ntFinal = ntFinalEditText.text.toString().toDoubleOrNull()
        val notaPEP = notaPEPEditText.text.toString().toDoubleOrNull()

        if (ntParcial != null && ntFinal != null && notaPEP != null) {
            // Aplicar los porcentajes a las notas
            val promedioPonderado = (ntParcial * 0.2 + ntFinal * 0.2 + notaPEP * 0.6)

            // Crear un Intent para abrir la actividad "Resultado"
            val intent = Intent(this, Resultado::class.java)

            // Pasar el resultado como dato al intent
            intent.putExtra("average", promedioPonderado)

            // Abrir la actividad "Resultado"
            startActivity(intent)
        } else {

        }
    }

}


