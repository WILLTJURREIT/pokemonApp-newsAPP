package com.example.thepokemonapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.thepokemonapp.models.Pokemon

@Dao
interface PokemonDAO {

    @Insert
    suspend fun insertPokemon(pokemon: Pokemon)

    @Query("SELECT * FROM pokemons")
    fun getAllPokemons(): LiveData<List<Pokemon>>
}
