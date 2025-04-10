package com.example.thepokemonapp.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.thepokemonapp.db.FavoritePokemon
import com.example.thepokemonapp.models.Pokemon
import com.example.thepokemonapp.models.PokemonResponse
import com.example.thepokemonapp.repository.PokemonRepository
import kotlinx.coroutines.launch

class PokemonViewModel(private val repository: PokemonRepository) : ViewModel() {

    private val _pokemonList = MutableLiveData<PokemonResponse>()
    val pokemonList: LiveData<PokemonResponse> = _pokemonList

    fun fetchPokemons(limit: Int = 20, offset: Int = 0) {
        viewModelScope.launch {
            try {
                val response = repository.getPokemons(limit, offset)
                _pokemonList.value = response
            } catch (e: Exception) {
                // handle error
            }
        }
    }
    fun removeFavorite(id: Int) {
        viewModelScope.launch {
            repository.removeFavorite(id)
        }
    }
    fun addToFavorites(pokemon: FavoritePokemon) {
        viewModelScope.launch {
            repository.insertFavorite(pokemon)
        }
    }
    fun insertPokemon(pokemon: Pokemon) {
        viewModelScope.launch {
            repository.addToFavorites(pokemon)
        }
    }

    val favoritePokemons: LiveData<List<FavoritePokemon>> = repository.getAllFavoritePokemons()
}