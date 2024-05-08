package com.gabrielferrari.convertify.ui.activitiesButton

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.gabrielferrari.convertify.databinding.ActivityWeightButtonBinding

class WeightActivityButton : AppCompatActivity() {

    private val binding by lazy {
        ActivityWeightButtonBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initializeSpinners()
        initializeInputField()
    }

    private fun initializeSpinners() {
        val spinner: Spinner = binding.spinner
        val spinner2: Spinner = binding.spinner2

        val options = arrayOf(
            "Kilogram(kg)", "Gram(g)", "Milligram(mg)",
            "Ton(t)", "Pound(lb)", "Ounce(oz)"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, options
        )
        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        spinner.adapter = adapter

        val adapter2 = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item, options
        )
        adapter2.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        spinner2.adapter = adapter2

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                convertAndDisplayResult()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Não faz nada neste caso
            }
        }

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                convertAndDisplayResult()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Não faz nada neste caso
            }
        }
    }

    private fun initializeInputField() {
        binding.inputValue.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Não faz nada neste caso
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                convertAndDisplayResult()
            }

            override fun afterTextChanged(s: Editable?) {
                // Não faz nada neste caso
            }
        })
    }

    private fun convertAndDisplayResult() {
        val spinner1Value = binding.spinner.selectedItem.toString()
        val spinner2Value = binding.spinner2.selectedItem.toString()
        val inputValue = binding.inputValue.text.toString().toDoubleOrNull() ?: 0.0

        val result = convertWeight(spinner1Value, spinner2Value, inputValue)

        binding.textResult.text = result
    }

    private fun convertWeight(unitFrom: String, unitTo: String, value: Double): String {
        // Adicione a lógica de conversão de peso aqui
        // Este é apenas um exemplo básico
        val convertedWeight: Double = when (unitFrom) {
            "Kilogram(kg)" -> when (unitTo) {
                "Kilogram(kg)" -> value
                "Gram(g)" -> value * 1000
                "Milligram(mg)" -> value * 1_000_000
                "Ton(t)" -> value / 1000
                "Pound(lb)" -> value * 2.20462
                "Ounce(oz)" -> value * 35.274
                else -> value
            }
            "Gram(g)" -> when (unitTo) {
                "Kilogram(kg)" -> value / 1000
                "Gram(g)" -> value
                "Milligram(mg)" -> value * 1000
                "Ton(t)" -> value / 1_000_000
                "Pound(lb)" -> value / 453.592
                "Ounce(oz)" -> value / 28.3495
                else -> value
            }
            // Adicione casos para outras unidades aqui
            else -> value
        }
        return String.format("%.2f", convertedWeight)
    }
}