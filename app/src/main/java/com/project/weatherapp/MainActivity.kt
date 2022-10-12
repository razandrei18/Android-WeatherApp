package com.project.weatherapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.weatherapp.adapters.ForecastAdapter
import com.project.weatherapp.databinding.ActivityMainBinding
import com.project.weatherapp.viewModels.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.weatherResponse.observe(this) { weather ->

            binding.apply {
                tvCity.text = "Bucharest"
                tvTemperature.text = weather.temperature
                tvDescription.text = weather.description
                tvWind.text = "Wind: ${weather.wind}"
                forecastRV.apply {
                    adapter = ForecastAdapter(viewModel)
                    layoutManager = LinearLayoutManager(applicationContext)
                    setHasFixedSize(false)
                    adapter?.notifyDataSetChanged()
                }
            }
        }
    }
}