package com.project.weatherapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.project.weatherapp.BR
import com.project.weatherapp.R
import com.project.weatherapp.viewModels.WeatherViewModel

class ForecastAdapter(private val viewModel: WeatherViewModel): RecyclerView.Adapter<ForecastViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), viewType, parent, false)
        return ForecastViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(viewModel, position)
    }

    override fun getItemCount(): Int {
        return viewModel.weatherResponse.value?.forecast?.size ?: 0
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.forecast_item
    }
}

class ForecastViewHolder(private val binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(viewModel: WeatherViewModel, position: Int){
        binding.setVariable(BR.forecastItem, viewModel.weatherResponse.value?.forecast!![position])
        binding.executePendingBindings()
    }
}