package com.sunilsahoo.android.piechart

class PieInfo {
    var text: CharSequence?=null
    var color: Int = PieUtils.getRandomColor()
    var textColor: Int = PieUtils.getRandomColor()
    var segments: List<PieSegmentInfo>? = null
}
