package com.example.thepokemonapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavoritePokemon::class], version = 1)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun favoritePokemonDao(): FavoritePokemonDAO

    companion object {
        @Volatile
        private var INSTANCE: PokemonDatabase? = null

        fun getDatabase(context: Context): PokemonDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PokemonDatabase::class.java,
                    "pokemon_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
