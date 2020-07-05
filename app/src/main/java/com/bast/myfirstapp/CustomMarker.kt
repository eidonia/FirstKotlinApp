package com.bast.myfirstapp

import android.content.Context
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import kotlinx.android.synthetic.main.marker_view.view.*

class CustomMarker(context: Context, layoutResource: Int) : MarkerView(context, layoutResource) {
    override fun refreshContent(e: Entry?, highlight: Highlight?) {
        val value = e?.y?.toDouble() ?: 0.0
        var resText=""
        if (value.toString().length > 8) {
            resText = value.toString().substring(0,7)
        } else {
            resText = value.toString()
        }
        markerText.text=resText
        super.refreshContent(e, highlight)
    }

    override fun getOffsetForDrawingAtPoint(posX: Float, posY: Float): MPPointF {
        return MPPointF(-width / 2f, -height - 10f)
    }
}