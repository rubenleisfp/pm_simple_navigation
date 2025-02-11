# pm_simple_navigation

Esta aplicación es una implementación de una app de navegación utilizando Compose Navigation. La aplicación tiene dos pantallas principales: una pantalla de inicio y una pantalla de detalles.

## Pantalla de Inicio

La pantalla de inicio contiene un cuadro de texto donde el usuario puede escribir un mensaje y un botón etiquetado como "Next Screen". Al presionar este botón, la aplicación navega a la pantalla de detalles, pasando el texto ingresado por el usuario como parámetro.

## Pantalla de Detalles

La pantalla de detalles muestra el texto que el usuario ingresó en la pantalla de inicio. También incluye un botón que permite regresar a la pantalla de inicio.

## Navegación

La navegación entre las pantallas está gestionada por `NavigationStack`, que configura el grafo de navegación de la aplicación. Define las rutas de navegación y las pantallas asociadas utilizando el componente `NavHost` de Jetpack Compose Navigation.

## Tema

La aplicación utiliza un tema personalizado basado en Material Design 3, definido en el archivo `Theme.kt`.

## Requisitos

- Android SDK 24 o superior
- Compose Navigation y Material Design 3

La configuración y las dependencias de la aplicación están gestionadas a través de Gradle. Consulta los archivos `build.gradle.kts` y `settings.gradle.kts` para más información sobre las configuraciones del proyecto.

- La idea para esta aplicación viene de este [artículo de Medium](https://medium.com/@jpmtech/navigation-in-jetpack-compose-c9e1fcfd2cdd) que explica cómo crear una aplicación de navegación utilizando Compose Navigation.