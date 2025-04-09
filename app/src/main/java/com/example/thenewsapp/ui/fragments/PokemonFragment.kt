package com.example.thenewsapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.thenewsapp.R
import com.example.thenewsapp.databinding.FragmentPokemonBinding
import com.example.thenewsapp.viewmodels.PokemonViewModel

class PokemonFragment : Fragment(R.layout.fragment_pokemon) {

    private lateinit var binding: FragmentPokemonBinding
    private val pokemonViewModel: PokemonViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPokemonBinding.bind(view)

        val pokemonId = arguments?.getInt("pokemonId") ?: 1
        pokemonViewModel.fetchPokemonData(pokemonId)

        pokemonViewModel.pokemonData.observe(viewLifecycleOwner) { pokemon ->
            binding.pokemonName.text = pokemon.name
            binding.pokemonHeight.text = "Height: ${pokemon.height}"
            binding.pokemonWeight.text = "Weight: ${pokemon.weight}"

            val abilities = pokemon.abilities.joinToString(", ") { it.ability.name }
            binding.pokemonAbilities.text = "Abilities: $abilities"

            Glide.with(requireContext())
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${pokemonId}.png")
                .into(binding.pokemonImage)
        }

        pokemonViewModel.errorMessage.observe(viewLifecycleOwner) { error ->
            binding.pokemonName.text = error
        }
    }
}
