package fr.plaglefleau.api.models.bankapi.receive.put

data class PutChangePasswordReceive(val username: String, val password: String, val newPassword: String)
