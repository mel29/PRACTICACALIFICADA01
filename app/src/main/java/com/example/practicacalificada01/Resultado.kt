package com.example.practicacalificada01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.DecimalFormat

class Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val resultTextView = findViewById<TextView>(R.id.txtNotaFinal)
        val apruebaTextView = findViewById<TextView>(R.id.txtAprueba)

        val average = intent.getDoubleExtra("average", 0.0)

        // Redondear el resultado a dos decimales
        val decimalFormat = DecimalFormat("#.##")
        val roundedAverage = decimalFormat.format(average)

        // Mostrar el resultado ponderado redondeado
        resultTextView.text = "Promedio Ponderado: $roundedAverage"

        // Verificar si el promedio ponderado
        if (average > 10.5) {
            apruebaTextView.text = "Aprobado"
        } else {
            apruebaTextView.text = "No aprobado"
        }
    }
}
