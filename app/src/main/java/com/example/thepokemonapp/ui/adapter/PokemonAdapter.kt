package com.example.thepokemonapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.thepokemonapp.databinding.ItemPokemonBinding
import com.example.thepokemonapp.models.Pokemon

class PokemonAdapter(
    private val onItemClick: (Pokemon) -> Unit // Add an onClick listener parameter
) : ListAdapter<Pokemon, PokemonAdapter.PokemonViewHolder>(PokemonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(pokemon)
    }

    class PokemonViewHolder(
        private val binding: ItemPokemonBinding,
        private val onItemClick: (Pokemon) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                binding.pokemon?.let { pokemon -> onItemClick(pokemon) }
            }
        }

        fun bind(pokemon: Pokemon) {
            binding.pokemon = pokemon

        }
    }

    class PokemonDiffCallback : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }
    }
}
