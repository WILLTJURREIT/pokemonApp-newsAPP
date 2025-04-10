package com.example.thepokemonapp.api
// This creates and provides a single instance of the PokemonApiService used to make API calls throughout the app.
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://pokeapi.co/api/v2/"
    // Had to change from instance to apiService to not bypass the PokemonRepository
    val apiService: PokemonApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonApi::class.java)
    }
}
