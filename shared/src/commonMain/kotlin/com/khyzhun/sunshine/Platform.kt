package com.khyzhun.sunshine

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform