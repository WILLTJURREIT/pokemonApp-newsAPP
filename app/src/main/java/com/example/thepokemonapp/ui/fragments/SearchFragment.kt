package com.example.thepokemonapp.ui.fragments


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thepokemonapp.R
import com.example.thepokemonapp.databinding.FragmentSearchBinding
import com.example.thepokemonapp.ui.adapter.PokemonAdapter
import com.example.thepokemonapp.viewmodels.PokemonViewModel

class SearchFragment : Fragment(R.layout.fragment_search) {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var viewModel: PokemonViewModel
    private lateinit var adapter: PokemonAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)


        adapter = PokemonAdapter { pokemon ->

        }


        binding.recyclerSearch.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerSearch.adapter = adapter

         viewModel.filteredPokemonList.observe(viewLifecycleOwner, { pokemonList ->
            adapter.submitList(pokemonList)
        })


                binding.searchEdit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {

            }

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {

                val query = s.toString()
                viewModel.filterPokemons(query)
            }
        })
    }
}