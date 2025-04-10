package com.example.thepokemonapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thepokemonapp.ui.adapter.PokemonAdapter
import com.example.thepokemonapp.viewmodels.PokemonViewModel
import com.example.thepokemonapp.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {

    private lateinit var binding: FragmentFavoritesBinding
    private val viewModel: PokemonViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)

        val adapter = PokemonAdapter(emptyList()) { pokemon ->
            viewModel.removeFavorite(pokemon.id)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        viewModel.favoritePokemonList.observe(viewLifecycleOwner, { favorites ->
            adapter.submitList(favorites)
        })

        viewModel.getFavorites()

        return binding.root
    }
}
