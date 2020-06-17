package com.example.kotlinnews.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinnews.databinding.KotlinNewsRowBinding
import com.example.kotlinnews.model.Data
import com.example.kotlinnews.model.DataX
import com.example.kotlinnews.model.Model
import com.example.kotlinnews.model.RequiredInfo
import com.example.kotlinnews.ui.KotlinNewsDirections

class KotlinNewsAdapter (model: Model?): RecyclerView.Adapter<KotlinNewsAdapter.ViewHolder>() {
    private var data = model?.data?.children

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = KotlinNewsRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int{
        return data!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = data?.get(position)?.data
        val requiredInfo = RequiredInfo(data?.media?.oembed?.thumbnailUrl, data?.url, data?.title)
        holder.bind(data)
        holder.binding.cv.setOnClickListener {
            val action = KotlinNewsDirections.actionKotlinNewsToDetailKotlinNews(position, requiredInfo)
            it.findNavController().navigate(action)
        }
    }

    class ViewHolder(val binding: KotlinNewsRowBinding): RecyclerView.ViewHolder(binding.root){
       fun bind(data: DataX?){
           binding.data = data
           binding.executePendingBindings()
       }
    }
}