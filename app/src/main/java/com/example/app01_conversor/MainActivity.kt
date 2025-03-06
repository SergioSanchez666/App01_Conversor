package com.example.app01_conversor

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app01_conversor.ui.theme.App01_ConversorTheme

class MainActivity : ComponentActivity() {
    private lateinit var editTextValor: EditText
    private lateinit var spinnerUnidadOrigen: Spinner
    private lateinit var buttonConvertir: Button
    private lateinit var textViewPies: TextView
    private lateinit var textViewYardas: TextView
    private lateinit var textViewFahrenheit: TextView
    private lateinit var textViewGramos: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextValor = findViewById(R.id.editTextValor)
        spinnerUnidadOrigen = findViewById(R.id.spinnerUnidadOrigen)
        buttonConvertir = findViewById(R.id.buttonConvertir)
        textViewPies = findViewById(R.id.textViewPies)
        textViewYardas = findViewById(R.id.textViewYardas)
        textViewFahrenheit = findViewById(R.id.textViewFahrenheit)
        textViewGramos = findViewById(R.id.textViewGramos)

        buttonConvertir.setOnClickListener {
            val valor = editTextValor.text.toString().toDoubleOrNull() ?: 0.0 // Manejo de valores no numéricos
            val unidadOrigen = spinnerUnidadOrigen.selectedItemPosition

            when (unidadOrigen) {
                0 -> { // Metros
                    val pies = valor * 3.28084
                    val yardas = valor * 1.09361
                    textViewPies.text = String.format("%.2f pies", pies)
                    textViewYardas.text = String.format("%.2f yardas", yardas)
                }
                1 -> { // Grados centígrados
                    val fahrenheit = (valor * 1.8) + 32
                    textViewFahrenheit.text = String.format("%.2f °F", fahrenheit)
                }
                2 -> { // Kilos
                    val gramos = valor * 1000
                    textViewGramos.text = String.format("%.2f gramos", gramos)
                }
            }
        }
    }
}