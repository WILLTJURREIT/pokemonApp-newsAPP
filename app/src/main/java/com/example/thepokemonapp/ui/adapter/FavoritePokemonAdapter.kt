package com.example.thepokemonapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.thepokemonapp.R
import com.example.thepokemonapp.databinding.ItemPokemonBinding
import com.example.thepokemonapp.db.FavoritePokemon

class FavoritePokemonAdapter(
    private var favoriteList: List<FavoritePokemon>,
    private val onItemClick: (FavoritePokemon) -> Unit
) : ListAdapter<FavoritePokemon, FavoritePokemonAdapter.FavoriteViewHolder>(FavoriteDiffCallback()) {

    inner class FavoriteViewHolder(
        private val binding: ItemPokemonBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(favorite: FavoritePokemon) {
            binding.pokemonName.text = favorite.name
            val context = binding.root.context
            binding.pokemonWeight.text = context.getString(R.string.weight_text, favorite.weight)
            binding.root.setOnClickListener {
                onItemClick(favorite)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(favoriteList[position])
    }

    class FavoriteDiffCallback : DiffUtil.ItemCallback<FavoritePokemon>() {
        override fun areItemsTheSame(oldItem: FavoritePokemon, newItem: FavoritePokemon): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: FavoritePokemon,
            newItem: FavoritePokemon
        ): Boolean {
            return oldItem == newItem
        }
    }
}
