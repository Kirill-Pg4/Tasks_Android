package com.example.junior

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AnimalAdapter(private val animals: List<String>) :
    RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    inner class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false)
        return AnimalViewHolder(itemView)
    }

    override fun getItemCount(): Int = animals.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animalImageUrl = animals[position]
        Glide.with(holder.itemView)
            .load(animalImageUrl)
            .into(holder.itemView.findViewById<ImageView>(R.id.animalImageView))
    }
}
