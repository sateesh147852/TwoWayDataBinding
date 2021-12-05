package com.twowaydatabinding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.twowaydatabinding.databinding.HeroesItemBinding
import com.twowaydatabinding.model.Hero

class HeroesAdapter :
    RecyclerView.Adapter<HeroesAdapter.HeroesViewHolder>() {

    private var hero: List<Hero>? = null

    inner class HeroesViewHolder(val binding: HeroesItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        val heroesItemBinding =
            HeroesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeroesViewHolder(heroesItemBinding)
    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        holder.binding.hero = hero!![position]
    }

    fun updateData(hero: List<Hero>) {
        this.hero = hero
    }

    override fun getItemCount(): Int {
        return hero?.size ?: 0
    }
}