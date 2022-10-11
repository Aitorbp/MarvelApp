package com.example.marvelapp.utils

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class Constants {

        companion object {
            const val BASE_URL = "https://gateway.marvel.com:443/v1/public/characters/"
            val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()
            const val API_KEY = "7ce2b67f9996d8d44b22fa9080a29ec3"
            const val PRIVATE_KEY = "7bc1376ba85f49f53d96e7e1407f573428874c15"
            const val limit = "20"
            fun hash(): String{
                val input = "$timeStamp$PRIVATE_KEY$API_KEY"
                val md = MessageDigest.getInstance("MD5")
                return BigInteger(1,md.digest(input.toByteArray())).toString(16).padStart(32, '0')
            }

        }
}