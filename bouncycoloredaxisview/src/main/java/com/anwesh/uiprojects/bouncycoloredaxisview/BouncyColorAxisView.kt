package com.anwesh.uiprojects.bouncycoloredaxisview

/**
 * Created by anweshmishra on 07/03/20.
 */

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Canvas
import android.view.View
import android.view.MotionEvent
import android.content.Context
import android.app.Activity

val lines : Int = 2
val parts : Int = 3
val strokeFactor : Float = 90f
val sizeFactor : Float = 2.9f
val delay : Long = 25
val scGap : Float = 0.2f / parts
val backColor : Int = Color.parseColor("#BDBDBD")
val colors : Array<String> = arrayOf("#4CAF50", "#673AB7", "#f44336", "#01579B", "#009688")