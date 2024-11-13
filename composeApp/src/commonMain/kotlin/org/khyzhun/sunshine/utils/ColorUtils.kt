package org.khyzhun.sunshine.utils

import androidx.compose.ui.graphics.Color

object ColorUtils {

    fun parseColor(hex: String): Color {
        val color = hex.removePrefix("#")
        val red = color.substring(0, 2).toInt(16)
        val green = color.substring(2, 4).toInt(16)
        val blue = color.substring(4, 6).toInt(16)
        val alpha = if (color.length == 8) color.substring(6, 8).toInt(16) else 255
        return Color(red, green, blue, alpha)
    }

}