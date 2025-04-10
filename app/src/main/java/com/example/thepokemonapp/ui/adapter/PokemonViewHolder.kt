package com.example.thepokemonapp.ui.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.thepokemonapp.R

class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val nameTextView: TextView = view.findViewById(R.id.pokemon_name)
    val weightTextView: TextView = view.findViewById(R.id.pokemon_weight)
}
