package com.example.thepokemonapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_pokemons")
data class FavoritePokemon(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val weight: Float
)
