package com.example.thenewsapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.thenewsapp.models.Pokemon
import com.example.thenewsapp.network.RetrofitInstance
import kotlinx.coroutines.launch

class PokemonViewModel(application: Application) : AndroidViewModel(application) {

    val pokemonData = MutableLiveData<Pokemon>()
    val errorMessage = MutableLiveData<String>()

    fun fetchPokemonData(pokemonId: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.pokemonApiService.getPokemon(pokemonId)
                pokemonData.postValue(response)
            } catch (e: Exception) {
                errorMessage.postValue("Error fetching Pokémon data: ${e.message}")
            }
        }
    }
}
