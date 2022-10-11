package com.example.marvelapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvelapp.model.ResponseCharacters

class charactersVM : ViewModel() {
    val responseCharacters = MutableLiveData<ResponseCharacters>()
}