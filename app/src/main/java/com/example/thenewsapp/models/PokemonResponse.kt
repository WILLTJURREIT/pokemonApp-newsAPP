package com.example.thenewsapp.models

data class PokemonResponse(
    val name: String,
    val weight: Int,
    val abilities: List<Ability>
)

data class Ability(
    val ability: AbilityDetails
)

data class AbilityDetails(
    val name: String
)
