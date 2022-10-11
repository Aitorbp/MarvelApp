package com.example.marvelapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelapp.databinding.ActivityMainBinding
import com.example.marvelapp.model.ResultsItem
import com.example.marvelapp.service.MarvelAPI
import com.example.marvelapp.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: CharacterAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getAllCharacters()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getAllCharacters() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(MarvelAPI::class.java)
                .getAllCharacters(Constants.API_KEY, Constants.timeStamp, Constants.hash(), "20")
            val response = call.body()
            val charactersRes = response?.data?.results
            runOnUiThread {
                if (call.isSuccessful) {
                    //show recyclerview
                    initRecyclerView(charactersRes)
               //     characters.clear()
               //     characters.addAll(charactersRes?)
                    adapter.notifyDataSetChanged()
                } else {
                    //show error
                }
            }
        }
    }

    private fun initRecyclerView(charactersRes: List<ResultsItem?>?) {
        adapter = CharacterAdapter(charactersRes as MutableList<ResultsItem?>?)
        binding.reciclerViewCharacters.layoutManager = GridLayoutManager(applicationContext,2)
        binding.reciclerViewCharacters.adapter = adapter

    }

}












