package com.example.marvelapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.marvelapp.model.ResultsItem
import com.squareup.picasso.Picasso


class DetailFragment(item: ResultsItem?) : Fragment()  {

    var item1: ResultsItem? = item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_detail, container, false)

        val superheroName = root?.findViewById(R.id.nameCharacterFragment) as TextView
        val superheroImage = root?.findViewById(R.id.imageCharacterFragment) as ImageView
        superheroName.text = item1?.name
        loadUrl(item1, superheroImage)

        return root
    }


    fun  loadUrl(item: ResultsItem?, superheroImage: ImageView) {
        var https = "https"
        var url = "${item?.thumbnail?.path}/portrait_xlarge.${item?.thumbnail?.extension}"
        val n = 4
        var urlFormatter =   url.substring(n)

        Picasso.get().load(https.plus(urlFormatter))
            .fit().into(superheroImage)
    }
}