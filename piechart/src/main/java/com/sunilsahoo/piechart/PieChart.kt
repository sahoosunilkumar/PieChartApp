package com.sunilsahoo.piechart

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView

class PieChart : FrameLayout {
    private lateinit var graphInfoLayout: LinearLayout
    private lateinit var graphView: GraphView
    private lateinit var graphInfoText: TextView
        constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
        context!!, attrs, defStyle
    ) {
        initView()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    ) {
        initView()
    }

    constructor(context: Context?) : super(context!!) {
        initView()
    }

    private fun initView() {
        inflate(context, R.layout.graph_layout, this)
        graphInfoLayout = findViewById(R.id.graph_info_layout)
        graphView = findViewById(R.id.graph)
        graphInfoText = findViewById(R.id.graph_info_text)
        this.visibility = GONE
    }

    fun updateInfo(pieInfo: PieInfo){
        if (pieInfo.segments?.isEmpty() == false){
            this.visibility = VISIBLE
            graphInfoLayout.removeAllViews()
            graphView.update(pieInfo)
            pieInfo.text?.let { graphInfoText.text = it }
            pieInfo.segments?.forEach {
                val child = inflate(context, R.layout.graph_info_item, null)
                val view:View = child.findViewById(R.id.graph_hint_view)
                view.setBackgroundColor(it.color)
                val text = child.findViewById<TextView>(R.id.graph_hint)
                text.text = it.text
                graphInfoLayout.addView(child)
            }
        }else{
            this.visibility = GONE
        }

    }
}