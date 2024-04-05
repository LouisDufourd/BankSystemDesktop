package fr.plaglefleau.api.models.bankapi.response.get

import com.google.gson.annotations.SerializedName
import fr.plaglefleau.api.models.bankapi.bdd.User
import fr.plaglefleau.api.models.bankapi.response.BaseResponse

data class GetUserResponse(@SerializedName("getUserResponseMessage") override val message: String, val user: User?): BaseResponse(message)
