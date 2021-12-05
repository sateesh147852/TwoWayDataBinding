package com.twowaydatabinding.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.twowaydatabinding.adapter.HeroesAdapter
import com.twowaydatabinding.databinding.ActivityMainBinding
import com.twowaydatabinding.viewmodel.MainViewModel
import com.twowaydatabinding.utils.Utilites

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var heroesAdapter: HeroesAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeRecyclerView()
        initializeViewModel()

    }

    private fun initializeRecyclerView() {
        heroesAdapter = HeroesAdapter()
        binding.rvHeroes.layoutManager = LinearLayoutManager(this)
        binding.rvHeroes.adapter = heroesAdapter

        startActivity(Intent(this,SecondActivity::class.java))
    }

    private fun initializeViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        if (Utilites.isNetWorkAvailable(this)) {
            viewModel.mutableHeroData.observe(this, Observer {
                heroesAdapter.updateData(it)
                heroesAdapter.notifyDataSetChanged()
            })
            viewModel.errorData.observe(this, Observer {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            })
        } else {
            Toast.makeText(this, "Please check your internet connection", Toast.LENGTH_SHORT).show()
        }

    }
}