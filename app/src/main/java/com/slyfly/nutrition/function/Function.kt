package com.slyfly.nutrition.function

import androidx.compose.ui.graphics.Brush
import com.slyfly.nutrition.ui.theme.EndBlue
import com.slyfly.nutrition.ui.theme.MiddleBlue
import com.slyfly.nutrition.ui.theme.StartBlue

class Function {
    fun functionGradientWhiteToBlue(): Brush {
        val gradient= Brush.verticalGradient(
            listOf(StartBlue, MiddleBlue, EndBlue),
            startY = 0.0f,
            endY = 300.0f
        )
        return gradient
    }

    fun functionGradientBlueToWhite():Brush{
        val gradientBlueToWhite=Brush.verticalGradient(
            listOf(EndBlue, MiddleBlue, StartBlue),
            startY = 0.0f,
            endY = 5000.0f
        )
        return gradientBlueToWhite
    }
    fun specialChar(char:String):String{
        val chars = setOf('[',',','/','_', '\\', '^', '$', '.', '|', '?', '*', '+', '(', ')')
return char.filter { it !in chars }
    }
}