package fr.plaglefleau.api.models.bankapi.receive.put

data class PutSendMoneyReceive(val username: String, val password: String, val originAccountID: String, val targetAccountID: String, val amount: Double)
