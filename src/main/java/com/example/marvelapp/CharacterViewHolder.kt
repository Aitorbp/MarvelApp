package com.example.marvelapp


import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.model.ResultsItem
import com.squareup.picasso.Picasso

class CharacterViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val superheroName = view.findViewById(R.id.tvCharacter) as TextView
    val superheroPhotoUrl = view.findViewById(R.id.ivCharacter) as ImageView

    fun bind(character: ResultsItem?) {
        superheroName.text = character?.name
       loadUrl(character)
    }

    fun  loadUrl(character: ResultsItem?) {
        var https = "https"
        var url = "${character?.thumbnail?.path}/portrait_xlarge.${character?.thumbnail?.extension}"
        val n = 4
        var urlFormatter =   url.substring(n)

        Picasso.get().load(https.plus(urlFormatter))
            .fit().into(superheroPhotoUrl)
    }



}





