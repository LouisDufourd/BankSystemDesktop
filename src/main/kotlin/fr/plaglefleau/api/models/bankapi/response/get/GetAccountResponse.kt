package fr.plaglefleau.api.models.bankapi.response.get

import com.google.gson.annotations.SerializedName
import fr.plaglefleau.api.models.bankapi.bdd.Account
import fr.plaglefleau.api.models.bankapi.response.BaseResponse

data class GetAccountResponse(@SerializedName("getAccountMessage")override val message: String, val account: Account?) : BaseResponse(message)
