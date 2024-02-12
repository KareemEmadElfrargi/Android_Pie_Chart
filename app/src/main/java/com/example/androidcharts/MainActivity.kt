package com.example.androidcharts

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidcharts.databinding.ActivityMainBinding
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list : ArrayList<PieEntry> = ArrayList()

        list.add(PieEntry(180f, 0))
        list.add(PieEntry(24f, 1))
        list.add(PieEntry(30f, 2))
        list.add(PieEntry(35f, 3))
        list.add(PieEntry(40f, 4))

        // sets various properties of the dataset like colors, text color, and text size
        val pieDataSet = PieDataSet(list,"List")

        pieDataSet.colors = ColorTemplate.COLORFUL_COLORS.toList()
        pieDataSet.valueTextColor = Color.BLACK
        pieDataSet.valueTextSize = 14f

        val pieData = PieData(pieDataSet)
        binding.pieChart.apply {
            data = pieData
            description.isEnabled = false
            centerText = "Age Group"
            animateY(1000) // to animate this chart
            invalidate()
        }

    }
}