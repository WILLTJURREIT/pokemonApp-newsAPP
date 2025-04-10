package com.example.thepokemonapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavoritePokemonDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoritePokemon(pokemon: FavoritePokemon)

    @Query("SELECT * FROM favorite_pokemon")
    fun getAllFavoritePokemons(): LiveData<List<FavoritePokemon>>

    @Query("DELETE FROM favorite_pokemon WHERE id = :id")
    suspend fun deleteFavoritePokemon(id: Int)
}
