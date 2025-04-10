package com.example.thepokemonapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thepokemonapp.databinding.FragmentFavoritesBinding
import com.example.thepokemonapp.ui.adapter.FavoritePokemonAdapter
import com.example.thepokemonapp.viewmodels.PokemonViewModel


class FavoritesFragment : Fragment() {

    private lateinit var binding: FragmentFavoritesBinding
    private lateinit var adapter: FavoritePokemonAdapter
    private val viewModel: PokemonViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        adapter = FavoritePokemonAdapter(emptyList()) { favorite ->
            viewModel.removeFavorite(favorite.id)
        }



        val adapter = FavoritePokemonAdapter(emptyList()) { favorite ->
            viewModel.removeFavorite(favorite.id)
        }

        binding.favoritesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.favoritesRecyclerView.adapter = adapter


        viewModel.favoritePokemons.observe(viewLifecycleOwner) { favorites ->
            adapter.submitList(favorites)
        }

        return binding.root
    }
}