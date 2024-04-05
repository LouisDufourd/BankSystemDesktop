package fr.plaglefleau.api

import fr.plaglefleau.models.currencyapi.Rate
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyRateApi {
    @GET("latest")
    suspend fun getLastRate(@Query("apikey") apiKey:String = "fca_live_FFu5pkaQrg6N2xmbplYYVqaXEL0zF9zclhdzBOXX", @Query("base_currency") baseCurrency:String, @Query("currencies") currencies:List<String>) : Response<Rate>
}