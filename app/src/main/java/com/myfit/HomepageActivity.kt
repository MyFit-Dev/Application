package com.myfit

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate

class HomepageActivity : AppCompatActivity() {

    private lateinit var pieChart: PieChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        pieChart = findViewById(R.id.pieChart)

        // Crea un ArrayList di PieEntry per i dati del grafico
        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(30f, "Proteine"))
        entries.add(PieEntry(20f, "Grassi"))
        entries.add(PieEntry(50f, "Carboidrati"))

        // Crea un PieDataSet con gli entry
        val dataSet = PieDataSet(entries, "Label")

        // Opzioni per il dataset
        dataSet.colors = listOf(Color.RED, Color.BLUE, Color.rgb(255, 165, 0))
        dataSet.valueTextColor = Color.WHITE
        dataSet.valueTextSize = 14f

        // Crea un PieData oggetto con il dataSet
        val data = PieData(dataSet)

        // Imposta le opzioni per il grafico
        pieChart.setUsePercentValues(true)
        pieChart.description.isEnabled = false
        pieChart.setHoleColor(Color.TRANSPARENT)
        pieChart.transparentCircleRadius = 0f
        pieChart.legend.isEnabled = false
        pieChart.data = data

        pieChart.invalidate() // Refresh del grafico
    }

}