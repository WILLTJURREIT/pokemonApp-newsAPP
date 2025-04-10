package com.example.thepokemonapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemons")
data class Pokemon(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val type: String,  // Example fields
    val weight: Float
)
