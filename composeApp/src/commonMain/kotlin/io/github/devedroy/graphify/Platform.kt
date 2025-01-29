package io.github.devedroy.graphify

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform