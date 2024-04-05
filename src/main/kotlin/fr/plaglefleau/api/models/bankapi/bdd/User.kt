package fr.plaglefleau.api.models.bankapi.bdd

import java.util.*

data class User(val id: Int, val username: String, val password:String, val firstname:String, val lastname:String, val address:String, val birthday:Calendar)
