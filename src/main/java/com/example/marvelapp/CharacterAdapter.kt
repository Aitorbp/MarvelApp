package com.example.marvelapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.model.ResultsItem

class CharacterAdapter(private val characters: MutableList<ResultsItem?>?) : RecyclerView.Adapter<CharacterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CharacterViewHolder(layoutInflater.inflate(R.layout.item_character, parent, false))
    }
    override fun getItemCount(): Int = characters?.size!!
    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = characters!![position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            val detailFragment = DetailFragment(item)
            showFragment(detailFragment ,it)
        }

    }

    fun showFragment(fragment: DetailFragment, view: View){
        val activity = view.context  as AppCompatActivity
        val fram = activity.supportFragmentManager.beginTransaction()
        fram.replace(R.id.activityMain, fragment)
        fram.commit()
    }

    interface Callbacks {
        fun handleUserData(data: ResultsItem)
    }


}

