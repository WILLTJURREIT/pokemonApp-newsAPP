package com.example.thenewsapp.repository

import com.example.thenewsapp.api.PokeApiService
import com.example.thenewsapp.models.PokemonResponse
import retrofit2.Response

class PokeRepository(private val pokeApiService: PokeApiService) {

    // Fetch Pokémon data by name from the Pokémon API
    suspend fun getPokemon(name: String): Response<PokemonResponse> {
        return pokeApiService.getPokemon(name)
    }
}
