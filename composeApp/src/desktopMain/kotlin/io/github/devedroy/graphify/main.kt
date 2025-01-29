package io.github.devedroy.graphify

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Graphify",
    ) {
        App()
    }
}