package com.example.thepokemonapp.api

import androidx.room.Query
import com.example.thepokemonapp.models.PokemonResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


object PokemonApiService {
    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    fun create(): PokemonApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(PokemonApiService::class.java)
    }

    interface PokemonApiService {
        @GET("pokemon")
        suspend fun getPokemons(
            @Query("limit") limit: Int,
            @Query("offset") offset: Int
        ): PokemonResponse
    }

}