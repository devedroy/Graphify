package io.github.devedroy.graphify.domain

data class BarData<X, Y : Number>(
    val xValue: X,
    val yValue: Y
)