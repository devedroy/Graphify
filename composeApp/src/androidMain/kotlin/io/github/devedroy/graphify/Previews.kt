package io.github.devedroy.graphify

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import io.github.devedroy.graphify.graph.BarData
import io.github.devedroy.graphify.graph.BarGraph

@androidx.compose.ui.tooling.preview.Preview
@Composable
fun BarGraphPreview() {
    val sampleData = listOf(
        BarData("A", 10),
        BarData("B", 20),
        BarData("C", 15),
        BarData("D", 25)
    )
    BarGraph<String, Int>(data = sampleData, barColor = Color.Red, yAxisInterval = 5f, showValues = false)
}