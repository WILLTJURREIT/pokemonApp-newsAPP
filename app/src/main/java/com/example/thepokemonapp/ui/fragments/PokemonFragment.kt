package com.example.thepokemonapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thepokemonapp.databinding.FragmentPokemonListBinding
import com.example.thepokemonapp.db.FavoritePokemon
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
            val favorite = FavoritePokemon(
                id = pokemon.id,
                name = pokemon.name,
                weight = pokemon.weight,
                type = pokemon.type
            )
            pokemonViewModel.addToFavorites(favorite)
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = pokemonAdapter


// Observes pokemonList LiveData from the ViewModel. When the list updates,
// submitList() efficiently updates the RecyclerView
// without needing to manually call notifyDataSetChanged().
        pokemonViewModel.pokemonList.observe(viewLifecycleOwner) { response ->
            pokemonAdapter.submitList(response.results)//this
        }

        //this will fetch the data from the API
        pokemonViewModel.fetchPokemons()
        return binding.root
    }
}
