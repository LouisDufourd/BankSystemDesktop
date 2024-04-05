package fr.plaglefleau.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Api {
    val currencyRateApi: CurrencyRateApi = Retrofit.Builder()
        .baseUrl("https://api.freecurrencyapi.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CurrencyRateApi::class.java)

    val bankApi:BankApi = Retrofit.Builder()
        .baseUrl("http://127.0.0.1:8080/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(BankApi::class.java)
}