package com.example.thenewsapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.thenewsapp.R
import com.example.thenewsapp.databinding.ActivityNewsBinding
import com.example.thenewsapp.db.ArticleDatabase
import com.example.thenewsapp.repository.NewsRepository
import com.example.thenewsapp.viewmodels.NewsViewModel
import com.example.thenewsapp.viewmodels.PokemonViewModel
import com.example.thenewsapp.viewmodels.PokemonViewModelFactory

class NewsActivity : AppCompatActivity() {
    lateinit var pokemonViewModel: PokemonViewModel
    lateinit var newsViewModel: NewsViewModel
    lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // News ViewModel setup
        val newsRepository = NewsRepository(ArticleDatabase(this))
        val newsViewModelFactory = NewsViewModelProviderFactory(application, newsRepository)
        newsViewModel = ViewModelProvider(this, newsViewModelFactory).get(NewsViewModel::class.java)

        // Pokemon ViewModel setup
        val pokemonViewModelFactory = PokemonViewModelFactory(application)
        pokemonViewModel = ViewModelProvider(this, pokemonViewModelFactory).get(PokemonViewModel::class.java)

        // Set up the Navigation Controller
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Set up bottom navigation to handle the Pokémon fragment as well
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}
