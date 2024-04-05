package fr.plaglefleau.api

import fr.plaglefleau.api.models.bankapi.receive.delete.DeleteAccountReceive
import fr.plaglefleau.api.models.bankapi.receive.delete.DeleteUserReceive
import fr.plaglefleau.api.models.bankapi.receive.post.PostCreateAccountReceive
import fr.plaglefleau.api.models.bankapi.receive.post.PostCreateUserReceive
import fr.plaglefleau.api.models.bankapi.receive.put.PutChangePasswordReceive
import fr.plaglefleau.api.models.bankapi.receive.put.PutSendMoneyReceive
import fr.plaglefleau.api.models.bankapi.response.BaseResponse
import fr.plaglefleau.api.models.bankapi.response.get.GetAccountResponse
import fr.plaglefleau.api.models.bankapi.response.get.GetBalanceResponse
import fr.plaglefleau.api.models.bankapi.response.get.GetUserResponse
import fr.plaglefleau.api.models.bankapi.response.get.LoginResponse
import fr.plaglefleau.models.response.get.GetAccountsResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface BankApi {
    //GET
    @GET("user/login/{username}/{password}")
    fun login(@Path(value="username") username: String, @Path("password") password: String) : Call<LoginResponse>

    @GET("user/{username}")
    fun getUser(@Path(value="username") username: String) : Response<GetUserResponse>
    @GET("user/{userID}")
    fun getUser(@Path(value="userID") userID: Int) : Response<GetUserResponse>

    @GET("user/totalBalance/{username}")
    fun getTotalBalance(@Path("username") username: String) : Response<GetBalanceResponse>
    @GET("user/totalBalance/{userID}")
    fun getTotalBalance(@Path("userID") userID: Int) : Response<GetBalanceResponse>

    @GET("user/accounts/{username}")
    fun getAccounts(@Path("username") username: String) : Response<GetAccountsResponse>
    @GET("user/accounts/{userID}")
    fun getAccounts(@Path("userID") userID: Int) : Response<GetAccountsResponse>

    @GET("account/{accountID}")
    fun getAccount(@Path("accountID") accountID: String) : Response<GetAccountResponse>

    @GET("account/balance/{accountID}")
    fun getBalance(@Path("accountID") accountID: String) : Response<GetBalanceResponse>

    //POST
    @POST("user/register")
    fun registerUser(@Body postCreateUserReceive: PostCreateUserReceive) : Response<BaseResponse>

    @POST("account/create")
    fun createAccount(@Body postCreateAccountReceive: PostCreateAccountReceive) : Response<BaseResponse>

    //PUT
    @PUT("user/changePassword")
    fun getUser(@Body putChangePasswordReceive: PutChangePasswordReceive) : Response<BaseResponse>

    @PUT("account/sendMoney")
    fun sendMoney(@Body putSendMoneyReceive: PutSendMoneyReceive) : Response<BaseResponse>

    //DELETE
    @DELETE("user/delete")
    fun deleteUser(@Body deleteUserReceive: DeleteUserReceive) : Response<BaseResponse>

    @DELETE("account/delete")
    fun deleteAccount(@Body deleteAccountReceive: DeleteAccountReceive) : Response<BaseResponse>
}