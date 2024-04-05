package fr.plaglefleau.api.models.bankapi.response.get

import com.google.gson.annotations.SerializedName
import fr.plaglefleau.api.models.bankapi.response.BaseResponse

data class LoginResponse(@SerializedName("loginMessage") override val message: String, val isGoodLogin: Boolean) : BaseResponse(message)
