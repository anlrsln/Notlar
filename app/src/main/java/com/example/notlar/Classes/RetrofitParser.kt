package com.example.notlar.Classes

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitParser {

    // Bu classta retrofit, url'den json dosyasını alıp parse işlemi gerçekleştirir

    companion object{
        fun getClient(baseUrl:String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}