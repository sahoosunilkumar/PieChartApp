package com.sunilsahoo.android.piechart

import androidx.annotation.StyleRes

class PieInfo {
    var text: CharSequence?=null
    var color: Int = PieUtils.getRandomColor()
    var segments: List<PieSegmentInfo>? = null
    @StyleRes
    var pieChartSegmentTextStyle: Int ?= null
    @StyleRes
    var pieChartTitleTextStyle: Int ?= null
}
