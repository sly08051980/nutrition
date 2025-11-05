package com.slyfly.nutrition.data

data class UserInfo(
    val id:Int?=null,
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