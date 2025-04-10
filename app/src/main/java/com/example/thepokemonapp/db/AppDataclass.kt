package com.example.thepokemonapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.thepokemonapp.models.Pokemon

@Database(entities = [Pokemon::class, FavoritePokemon::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun pokemonDao(): PokemonDAO
    abstract fun favoritePokemonDao(): FavoritePokemonDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "pokemon-db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
