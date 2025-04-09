package com.example.thenewsapp.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.thenewsapp.R
import com.example.thenewsapp.databinding.FragmentHeadlinesBinding
import com.example.thenewsapp.ui.NewsActivity
import com.example.thenewsapp.viewmodels.PokemonViewModel

class HeadlinesFragment : Fragment(R.layout.fragment_headlines) {

    lateinit var pokemonViewModel: PokemonViewModel
    lateinit var binding: FragmentHeadlinesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHeadlinesBinding.bind(view)


        pokemonViewModel = (activity as NewsActivity).pokemonViewModel


        val goToPokemonButton = view.findViewById<Button>(R.id.goToPokemonButton)
        goToPokemonButton.setOnClickListener {

            val pokemonId = 123


            val action = HeadlinesFragmentDirections.actionHeadlinesFragmentToPokemonFragment(pokemonId)
            findNavController().navigate(action)
        }


        pokemonViewModel.pokemonData.observe(viewLifecycleOwner, Observer { pokemon ->

            binding.pokemonName.text = pokemon.name
            binding.pokemonHeight.text = "Height: ${pokemon.height}"
            binding.pokemonWeight.text = "Weight: ${pokemon.weight}"
        })


        pokemonViewModel.errorMessage.observe(viewLifecycleOwner, Observer { errorMessage ->
            binding.errorText.text = errorMessage
        })
    }
}
