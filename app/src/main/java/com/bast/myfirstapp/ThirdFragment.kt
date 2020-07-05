package com.bast.myfirstapp

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
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

        val vl = LineDataSet(entries, "Data List")

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

        val markerView = CustomMarker(requireContext(), R.layout.marker_view)
        lineChart.marker = markerView




        view.findViewById<Button>(R.id.buttonValue).setOnClickListener{
            val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)

            val values = view.findViewById<EditText>(R.id.editValue).text.toString()
            val valueList: List<String> = values.split(" ")
            Log.e("list", "valueList $valueList")

            val valuesArray = ArrayList<Entry>()

            for (i in 0..valueList.lastIndex){
                valuesArray.add(Entry((i+1).toFloat(), valueList[i].toFloat()))
            }

            val vl = LineDataSet(valuesArray, "Values")

            vl.setDrawValues(false)
            //vl.setDrawFilled(true)
            vl.lineWidth = 3f
            vl.setColors(Color.parseColor("#F48FB1"))
            //vl.fillColor = Color.parseColor("#00FFFFFF")
            vl.setCircleColor(Color.parseColor("#F48FB1"))

            valueChart.xAxis.labelRotationAngle = 0f
            valueChart.data = LineData(vl)

            valueChart.axisRight.isEnabled = false
            valueChart.xAxis.position = XAxis.XAxisPosition.BOTTOM

            valueChart.setTouchEnabled(true)
            valueChart.setPinchZoom(true)
            valueChart.setNoDataText("")

            valueChart.animateXY(900, 900)

            val markerView = CustomMarker(requireContext(), R.layout.marker_view)
            valueChart.marker = markerView




        }








    }

}

