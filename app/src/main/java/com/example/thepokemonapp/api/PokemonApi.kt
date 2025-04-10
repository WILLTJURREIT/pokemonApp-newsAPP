package com.example.thepokemonapp.api

import retrofit2.http.Query // I changed this due to the error with Query I looked up this import. it solved my error.
import com.example.thepokemonapp.models.PokemonResponse
import retrofit2.http.GET

// (This seems correct.. but I will fix other issues then circle back to it)
// It defines a Retrofit API call that fetches a list of Pokémon from the PokéAPI using limit and offset for pagination.
interface PokemonApi { // note I changed this to PokemonApi since if I take it out of the object it references it 2 times.
    @GET("pokemon")
    suspend fun getPokemons(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonResponse
}