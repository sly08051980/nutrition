package com.slyfly.nutrition.model

import androidx.annotation.DrawableRes

data class ItemBody(
    val name:String,
    @DrawableRes val image:Int,
    val onClick: (() -> Unit)? = null)


