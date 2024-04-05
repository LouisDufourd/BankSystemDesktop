package fr.plaglefleau.api.models.bankapi.receive.post

import java.util.*

data class PostCreateUserReceive(val username: String, val password: String, val firstname:String, val lastname:String, val birthday: Calendar, val address: String)
