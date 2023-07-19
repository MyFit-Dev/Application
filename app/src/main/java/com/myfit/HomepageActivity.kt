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

        setupChart(2000, 0, 0)
    }

    fun setupChart(goal: Int, food: Int, exercise: Int) {
        val rest = goal - food;

        //goal : 100 = food : x
        val percFood: Float = ((food * 100) / goal).toFloat()
        val percExercise: Float = (((exercise - food) * 100) / (goal)).toFloat()

        pieChart = findViewById(R.id.pieChart)

        // Crea un ArrayList di PieEntry per i dati del grafico
        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(percExercise, "Esercizio"))
        entries.add(PieEntry(percFood, "Alimenti"))

        if (rest > 0)
            entries.add(PieEntry((1-percFood), "Resto"))
        else
            entries.add(PieEntry(0f, "Resto"))

        entries.add(PieEntry(10f, "Resto"))

        // Crea un PieDataSet con gli entry
        val dataSet = PieDataSet(entries, "Label")

        // Opzioni per il dataset
        dataSet.colors = listOf(Color.rgb(219,76,64), Color.rgb(60, 185, 183), Color.rgb(226, 226, 226))

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