package com.example.thepokemonapp

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thepokemonapp.models.Pokemon
import com.example.thepokemonapp.viewmodels.PokemonViewModel
import com.example.thepokemonapp.ui.adapter.PokemonAdapter

class PokemonActivity : AppCompatActivity() {


    private val pokemonViewModel: PokemonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon)


        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_nav_view)


        val navController: NavController = this.findNavController(R.id.nav_host_fragment)


        NavigationUI.setupWithNavController(bottomNavigationView, navController)


        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = PokemonAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


        pokemonViewModel.allPokemons.observe(this, Observer { pokemons ->

            pokemons?.let { adapter.submitList(it) }
        })


        val newPokemon = Pokemon(id = 0, name = "Pikachu", type = "Electric", weight = 6.0f)
        pokemonViewModel.insertPokemon(newPokemon)


        Log.d("PokemonActivity", "Pokemon inserted: $newPokemon")
    }
}
