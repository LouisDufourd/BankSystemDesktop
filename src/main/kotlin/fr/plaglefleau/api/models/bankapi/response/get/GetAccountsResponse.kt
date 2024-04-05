package fr.plaglefleau.models.response.get

import com.google.gson.annotations.SerializedName
import fr.plaglefleau.api.models.bankapi.bdd.Account
import fr.plaglefleau.api.models.bankapi.response.BaseResponse

data class GetAccountsResponse(@SerializedName("getAccountsMessage")override val message: String, val account: List<Account>) : BaseResponse(message)
