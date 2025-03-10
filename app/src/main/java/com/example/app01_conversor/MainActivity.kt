package com.example.app01_conversor
//Miembros del equipo:
//Coronel Meza Sergio Daniel
//Sanchez Cruz Sergio Antonio

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
    // Declaración de variables para los elementos de la interfaz de usuario.
    private lateinit var editTextValor: EditText // Campo de entrada para el valor a convertir.
    private lateinit var spinnerUnidadOrigen: Spinner // Selector para la unidad de origen.
    private lateinit var buttonConvertir: Button // Botón para realizar la conversión.
    private lateinit var textViewPies: TextView // TextView para mostrar el resultado en pies.
    private lateinit var textViewYardas: TextView // TextView para mostrar el resultado en yardas.
    private lateinit var textViewFahrenheit: TextView // TextView para mostrar el resultado en grados Fahrenheit.
    private lateinit var textViewGramos: TextView // TextView para mostrar el resultado en gramos.

    @SuppressLint("MissingInflatedId") // Supresión de la advertencia de findViewById (se asume que los IDs están correctos).
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Establece el layout de la actividad.

        // Inicialización de las variables con los elementos de la interfaz de usuario.
        editTextValor = findViewById(R.id.editTextValor)
        spinnerUnidadOrigen = findViewById(R.id.spinnerUnidadOrigen)
        buttonConvertir = findViewById(R.id.buttonConvertir)
        textViewPies = findViewById(R.id.textViewPies)
        textViewYardas = findViewById(R.id.textViewYardas)
        textViewFahrenheit = findViewById(R.id.textViewFahrenheit)
        textViewGramos = findViewById(R.id.textViewGramos)

        // Configuración del listener para el botón de conversión.
        buttonConvertir.setOnClickListener {
            // Obtiene el valor ingresado por el usuario y lo convierte a Double, o 0.0 si no es un número.
            val valor = editTextValor.text.toString().toDoubleOrNull() ?: 0.0

            // Obtiene la posición del elemento seleccionado en el Spinner (unidad de origen).
            val unidadOrigen = spinnerUnidadOrigen.selectedItemPosition

            // Realiza la conversión según la unidad de origen seleccionada.
            when (unidadOrigen) {
                0 -> { // Metros a Pies y Yardas.
                    val pies = valor * 3.28084
                    val yardas = valor * 1.09361

                    // Formatea y muestra los resultados en los TextView correspondientes.
                    textViewPies.text = String.format("%.2f pies", pies)
                    textViewYardas.text = String.format("%.2f yardas", yardas)
                }
                1 -> { // Grados Centígrados a Fahrenheit.
                    val fahrenheit = (valor * 1.8) + 32

                    // Formatea y muestra el resultado en el TextView correspondiente.
                    textViewFahrenheit.text = String.format("%.2f °F", fahrenheit)
                }
                2 -> { // Kilogramos a Gramos.
                    val gramos = valor * 1000

                    // Formatea y muestra el resultado en el TextView correspondiente.
                    textViewGramos.text = String.format("%.2f gramos", gramos)
                }
            }
        }
    }
}