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

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n

fun Canvas.drawBouncyColorAxis(i : Int, scale : Float, size : Float, h : Float, paint : Paint) {
    val sc1 : Float = scale.divideScale(0, parts)
    val sc2 : Float = scale.divideScale(1, parts)
    val sc3 : Float = scale.divideScale(2, parts)
    val si : Float = 1f - 2 * i
    val sc2i : Float = sc2.divideScale(i, lines)
    val sc3i : Float = sc3.divideScale(i, lines)
    save()
    scale(1f, si)
    translate(0f, (h / 2) * sc3i)
    rotate(90f * sc2i)
    drawLine(0f, 0f, size * sc1, 0f, paint)
    restore()
}

fun Canvas.drawBouncyColorAxises(scale : Float, size : Float, h : Float, paint : Paint) {
    for (j in 0..(lines - 1)) {
        drawBouncyColorAxis(j, scale, size, h, paint)
    }
}

fun Canvas.drawBCANode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val size : Float = Math.min(w, h) / sizeFactor
    paint.color = Color.parseColor(colors[i])
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    save()
    translate(w / 2, h / 2)
    drawBouncyColorAxises(scale, size, h, paint)
    restore()
}

class BouncyColorAxisView(ctx : Context) : View(ctx) {

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}