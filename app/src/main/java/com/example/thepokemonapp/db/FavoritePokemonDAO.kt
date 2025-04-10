package com.example.thepokemonapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavoritePokemonDAO {
    @Insert
    suspend fun insert(favoritePokemon: FavoritePokemon)

    @Query("SELECT * FROM favorite_pokemons WHERE id = :id")
    suspend fun getFavoritePokemonById(id: Int): FavoritePokemon
}
