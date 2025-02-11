package com.fp

sealed class Screen(val route: String) {
    //Definimos primero las rutas de las pantallas
    object Main: Screen("main_screen")
    object Detail: Screen("detail_screen")
}