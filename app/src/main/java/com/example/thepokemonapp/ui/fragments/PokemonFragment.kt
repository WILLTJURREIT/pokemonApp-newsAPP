package com.example.thepokemonapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thepokemonapp.databinding.FragmentPokemonListBinding
import com.example.thepokemonapp.ui.adapter.PokemonAdapter
import com.example.thepokemonapp.viewmodels.PokemonViewModel

class PokemonFragment : Fragment() {

    private lateinit var binding: FragmentPokemonListBinding
    private lateinit var pokemonViewModel: PokemonViewModel
    private lateinit var pokemonAdapter: PokemonAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokemonListBinding.inflate(inflater, container, false)
        pokemonViewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)

        pokemonAdapter = PokemonAdapter { pokemon ->
            // Handle item click
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = pokemonAdapter

        pokemonViewModel.pokemonList.observe(viewLifecycleOwner, {
            pokemonAdapter.submitList(it)
        })

        return binding.root
    }
}
