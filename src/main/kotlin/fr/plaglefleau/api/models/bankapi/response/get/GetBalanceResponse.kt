package fr.plaglefleau.api.models.bankapi.response.get

import com.google.gson.annotations.SerializedName
import fr.plaglefleau.api.models.bankapi.response.BaseResponse

data class GetBalanceResponse(@SerializedName("getBalanceMessage") override val message: String, val balance: Double): BaseResponse(message)
