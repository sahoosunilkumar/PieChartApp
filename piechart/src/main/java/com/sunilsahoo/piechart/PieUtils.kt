package com.sunilsahoo.piechart

import android.graphics.Color
import java.util.*

object PieUtils {
    private val random = Random()

    /**
     * Creates RGB color from Hex decimal string
     */
    fun toColorInt(hex: String): Int {
        val color = hex.replace("#", "").toLong(16).toInt()
        val r = color shr 16 and 0xFF
        val g = color shr 8 and 0xFF
        val b = color shr 0 and 0xFF
        return Color.rgb(r, g, b)
    }

    /**
     * It calculates Percentage from PieInfo
     */
    fun calculatePercentage(pieInfo: PieInfo){
        var total = 0f
        pieInfo.segments?.let {
            for (i in it.indices) {
                total += it[i].actualValue?:0f
            }
            for (i in it.indices) {
                it[i].percentage = 360 * ((it[i].actualValue ?: 0f) / total)
            }
        }
    }

    fun getRandomColor(): Int {
        return Color.argb(
            255, random.nextInt(256), random.nextInt(256),
            random.nextInt(256)
        )
    }
}