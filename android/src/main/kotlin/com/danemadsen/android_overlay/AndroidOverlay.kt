package com.danemadsen.android_overlay

import android.content.pm.ActivityInfo
import android.view.WindowManager
import android.view.Gravity

object Overlay {
    var x = 0.0f
    var y = 0.0f
    var height: Int = WindowManager.LayoutParams.MATCH_PARENT
    var width: Int = WindowManager.LayoutParams.MATCH_PARENT
    var alignment = Gravity.CENTER
    var draggable = false
    var snapping = false
    var entryPoint: String = ""

    fun getCenterX(screenWidth: Int): Int {
        if (alignment == Gravity.LEFT) {
            return screenWidth / 2
        } 
        else if (alignment == Gravity.RIGHT) {
            return -(screenWidth / 2)
        }
        return 0
    }

    fun getLeftEdge(screenWidth: Int): Int {
        if (alignment == Gravity.LEFT) {
            return 0
        } 
        else if (alignment == Gravity.RIGHT) {
            return -screenWidth
        }
        return -(screenWidth / 2)
    }

    fun getRightEdge(screenWidth: Int): Int {
        if (alignment == Gravity.LEFT) {
            return screenWidth
        } 
        else if (alignment == Gravity.RIGHT) {
            return 0
        }
        return screenWidth / 2
    }

    fun getSnapX(currentX: Int, screenWidth: Int): Int {
        val rightEdge = getRightEdge(screenWidth)
        val leftEdge = getLeftEdge(screenWidth)
        return if (currentX < getCenterX(screenWidth)) leftEdge else rightEdge
    }
}
