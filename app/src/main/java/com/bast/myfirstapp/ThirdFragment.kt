package com.bast.myfirstapp

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.fragment_third.*

class ThirdFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstancedState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val entries = ArrayList<Entry>()
        entries.add(Entry(1f, 10f))
        entries.add(Entry(2f, 2f))
        entries.add(Entry(3f, 7f))
        entries.add(Entry(4f, 20f))
        entries.add(Entry(5f, 16f))
        entries.add(Entry(6f, 10f))
        entries.add(Entry(7f, 15f))
        entries.add(Entry(8f, 13f))
        entries.add(Entry(9f, 18f))
        entries.add(Entry(10f, 5f))
        entries.add(Entry(11f, 1f))
        entries.add(Entry(12f, 5f))
        entries.add(Entry(13f, 10f))
        entries.add(Entry(14f, 20f))
        entries.add(Entry(16f, 16f))

        view.findViewById<Button>(R.id.buttonToFirst).setOnClickListener{
            findNavController().navigate(R.id.action_thirdFragment_to_FirstFragment)
        }

        val vl = LineDataSet(entries, "MyData")

        vl.setDrawValues(false)
        vl.setDrawFilled(true)
        vl.lineWidth = 3f
        vl.setColors(Color.parseColor("#F48FB1"))
        vl.fillColor = Color.parseColor("#00FFFFFF")
        vl.setCircleColor(Color.parseColor("#F48FB1"))

        lineChart.xAxis.labelRotationAngle = 0f
        lineChart.data = LineData(vl)

        lineChart.axisRight.isEnabled = false
        lineChart.xAxis.position = XAxis.XAxisPosition.BOTTOM

        lineChart.setTouchEnabled(true)
        lineChart.setPinchZoom(true)

        lineChart.description.text = "Days"
        lineChart.setNoDataText("No data yet")

        lineChart.animateX(1800, Easing.EaseInExpo)









    }

}

