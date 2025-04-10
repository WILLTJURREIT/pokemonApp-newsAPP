package com.example.thepokemonapp.repository

import androidx.lifecycle.LiveData
import com.example.thepokemonapp.db.FavoritePokemon
import com.example.thepokemonapp.db.FavoritePokemonDAO
import com.example.thepokemonapp.api.PokemonApiService
import com.example.thepokemonapp.models.PokemonResponse

class PokemonRepository(
    private val pokemonDao: FavoritePokemonDAO
) {

    private val apiService = PokemonApiService.create()

    suspend fun getPokemons(): PokemonResponse {
        return apiService.getPokemons()
    }

    suspend fun insertFavorite(pokemon: FavoritePokemon) {
        pokemonDao.insertFavoritePokemon(pokemon)
    }

    fun getAllFavoritePokemons(): LiveData<List<FavoritePokemon>> {
        return pokemonDao.getAllFavoritePokemons()
    }
}
