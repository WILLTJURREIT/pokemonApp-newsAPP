package com.example.thepokemonapp.repository

import androidx.lifecycle.LiveData
import com.example.thepokemonapp.db.FavoritePokemon
import com.example.thepokemonapp.db.FavoritePokemonDAO
import com.example.thepokemonapp.api.RetrofitClient
import com.example.thepokemonapp.models.Pokemon
import com.example.thepokemonapp.models.PokemonResponse

class PokemonRepository(
    private val favoritePokemonDao: FavoritePokemonDAO
) {
 // ❌ Wrong: bypasses RetrofitClient
   // private val apiService = PokemonApiService.create()

    private val apiService = RetrofitClient.apiService// ✅ Uses the singleton instance

    suspend fun getPokemons(limit: Int, offset: Int): PokemonResponse {
        return apiService.getPokemons(limit, offset) // added Parameters to match PokemonApi
    }
// Room Database Methods
    suspend fun insertFavorite(pokemon: FavoritePokemon) {
        favoritePokemonDao.insertFavoritePokemon(pokemon)
    }
    suspend fun removeFavorite(id: Int) {
        favoritePokemonDao.deleteFavoritePokemon(id)
    }
    fun getAllFavoritePokemons(): LiveData<List<FavoritePokemon>> {
        return favoritePokemonDao.getAllFavoritePokemons()
    }
    suspend fun addToFavorites(pokemon: Pokemon) {
        val favorite = FavoritePokemon(
            id = pokemon.id,
            name = pokemon.name,
            type = pokemon.type,
            weight = pokemon.weight
        )
        favoritePokemonDao.insertFavoritePokemon(favorite)
    }

}
