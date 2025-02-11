package com.fp

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fp.ui.theme.Pm_simple_navigationTheme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.navigation.NavController

/**
 * Esta aplicacion es una implementacion de una app de navegacion con Compose Navigation.
 * La app tiene dos pantallas: una pantalla de inicio y una pantalla de detalles.
 * La pantalla de inicio tiene un cuadro de texto para escribir un mensaje
 * y un boton "Next Screen"
 * Al pulsar el boton "Next Screen", la app navega a la pantalla de detalles.
 * La pantalla de detalles pinta el texto recibido desde la caja de texto de la pantalla
 * inicial. Contiene un boton para volver a la pantalla inicial.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Pm_simple_navigationTheme {


                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /**
                     * NavigationStack es una funcion que define la navegacion entre pantallas.
                     * La navegacion se define como una serie de pantallas que se pueden navegar
                     * con el boton de navegaci n.
                     */
                    NavigationStack()
                }
            }
        }
    }
}

/**
 * Pantalla principal de la app. Esta pantalla tiene un cuadro de texto y un boton.
 * El cuadro de texto permite al usuario escribir un texto, y el boton permite navegar a la
 * pantalla de detalles.
 */
@Composable
fun MainScreen(navController: NavController) {
    /**
     * Se crea una variable mutable que almacena el texto escrito por el usuario.
     * La variable se inicializa con un valor vacio.
     */
    val text = remember {
        mutableStateOf("")
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(value = text.value, onValueChange = {
            text.value = it
        })

        /**
         * Se define un boton que permite navegar a la pantalla de detalles.
         * El boton pasa el texto escrito por el usuario como par metro a la pantalla de detalles.
         */
        Button(onClick = {
            navController.navigate(route = Screen.Detail.route + "?text=${text.value}")
        }) {
            Text("Next Screen")
        }
    }
}

/**
 * Pantalla de detalles. Esta pantalla muestra el texto escrito por el usuario en la pantalla
 * principal.
 */
@Composable
fun DetailScreen(navController: NavController, text: String?) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Detail Screen")
        /**
         * Se muestra el texto escrito por el usuario en la pantalla principal.
         */
        Text("$text")
        /**
         * Se define un boton que permite navegar a la pantalla de inicio
         */
        Button(onClick = {
            navController.navigate(route = Screen.Main.route)
        }) {
            Text("Go to init")
        }
    }
}

/**
 * Vista previa de la pantalla principal.
 */
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pm_simple_navigationTheme {
        NavigationStack()
    }
}