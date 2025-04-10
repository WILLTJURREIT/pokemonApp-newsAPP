package com.example.thepokemonapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.thepokemonapp.db.AppDatabase
import com.example.thepokemonapp.db.PokemonDAO
import com.example.thepokemonapp.models.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonViewModel(application: Application) : AndroidViewModel(application) {

    private val pokemonDao: PokemonDAO = AppDatabase.getDatabase(application).pokemonDao()
    val allPokemons: LiveData<List<Pokemon>> = pokemonDao.getAllPokemons()


    fun insertPokemon(pokemon: Pokemon) {
        viewModelScope.launch(Dispatchers.IO) {
            pokemonDao.insertPokemon(pokemon)
        }
    }
}
