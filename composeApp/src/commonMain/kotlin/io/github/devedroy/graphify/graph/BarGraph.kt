package io.github.devedroy.graphify.graph

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class BarData<X, Y : Number>(
    val xValue: X,
    val yValue: Y
)

@Composable
fun <X, Y : Number> BarGraph(
    data: List<BarData<X, Y>>, // Accepts multiple data types
    modifier: Modifier = Modifier,
    barColor: Color = Color.Blue,
    barWidth: Dp = 32.dp,
    spacing: Dp = 8.dp,
    showValues: Boolean = true,
    yAxisInterval: Float = 5f,
    onBarClick: ((BarData<X, Y>) -> Unit)? = null
) {
    val maxValue = data.maxOfOrNull { it.yValue.toFloat() } ?: 1f
    val yAxisValues = (0..(maxValue / yAxisInterval).toInt()).map { (it * yAxisInterval).toInt() }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(start = 40.dp),
        horizontalArrangement = Arrangement.spacedBy(spacing),
        verticalAlignment = Alignment.Bottom
    ) {
        Column(
            modifier = Modifier.fillMaxHeight().padding(end = 8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            yAxisValues.reversed().forEach { yValue ->
                Text(
                    text = yValue.toString(),
                    fontSize = 12.sp,
                    modifier = Modifier.padding(end = 4.dp)
                )
            }
        }

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.spacedBy(spacing),
                verticalAlignment = Alignment.Bottom
            ) {
                data.forEach { barData ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .weight(1f)
                            .clickable { onBarClick?.invoke(barData) }
                    ) {
                        Box(
                            modifier = Modifier
                                .width(barWidth)
                                .fillMaxHeight(fraction = barData.yValue.toFloat() / maxValue)
                                .background(barColor)
                        )
                        if (showValues) {
                            Text(text = barData.yValue.toString(), fontSize = 12.sp)
                        }
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
                horizontalArrangement = Arrangement.spacedBy(spacing)
            ) {
                data.forEach { barData ->
                    Text(
                        text = barData.xValue.toString(),
                        fontSize = 14.sp,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}


