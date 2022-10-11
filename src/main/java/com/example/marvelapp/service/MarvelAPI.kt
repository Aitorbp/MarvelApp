package com.example.marvelapp.service

import android.provider.SyncStateContract
import com.example.marvelapp.model.ResponseCharacters
import com.example.marvelapp.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelAPI {
    @GET("/v1/public/characters")
    suspend fun getAllCharacters(
          @Query("apikey") apikey:String = Constants.API_KEY,
          @Query("ts") ts:String = Constants.timeStamp,
          @Query("hash")hash:String = Constants.hash(),
          @Query("offset")offset:String

    ) : Response<ResponseCharacters>
}


