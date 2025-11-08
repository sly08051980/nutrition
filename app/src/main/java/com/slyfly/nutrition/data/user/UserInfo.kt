package com.slyfly.nutrition.data.user

data class UserInfo(
    val id_users:Int?=null,
    val firstName:String,
    val lastName:String,
    val postalCode:String,
    val city:String,
    val email:String,
    val passwords:String
)

data class UserConnexion(
    val email:String,
    val passwords: String
)

data class ConnexionResponse(
    val success:Boolean,
    val message:String,
    val user:UserInfo?
)
data class RegisterResponse(
    val success: Boolean,
    val message: String
)
data class UpdateUser(
    val id_users:Int?=null,
    val firstName:String,
    val lastName:String,
    val postalCode:String,
    val city:String,
    val email:String,

)
data class UpdateResponse(
    val success:Boolean,
    val message:String
)
