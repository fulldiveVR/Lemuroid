/*
 *
 *  *  RetrogradeApplicationComponent.kt
 *  *
 *  *  Copyright (C) 2017 Retrograde Project
 *  *
 *  *  This program is free software: you can redistribute it and/or modify
 *  *  it under the terms of the GNU General Public License as published by
 *  *  the Free Software Foundation, either version 3 of the License, or
 *  *  (at your option) any later version.
 *  *
 *  *  This program is distributed in the hope that it will be useful,
 *  *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  *  GNU General Public License for more details.
 *  *
 *  *  You should have received a copy of the GNU General Public License
 *  *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *  *
 *
 */

package com.swordfish.touchinput.radial

import android.graphics.Color
import android.view.View
import com.google.android.material.color.MaterialColors
import com.swordfish.lemuroid.common.graphics.GraphicsUtils
import com.swordfish.radialgamepad.library.config.RadialGamePadTheme
import com.swordfish.touchinput.controller.R
import com.google.android.material.R as MaterialR

object LemuroidTouchOverlayThemes {

    private const val ALPHA_FILL_LIGHT = 0.2f
    private const val ALPHA_FILL_STRONG = 0.2f
    private const val ALPHA_FILL_SIMULATED = 0.4f
    private const val ALPHA_FILL_PRESSED = 0.6f

    private const val ALPHA_STROKE = 0.9f
    private const val ALPHA_STROKE_LIGHT = 0.15f * ALPHA_STROKE
    private const val ALPHA_STROKE_STRONG = 0.5f * ALPHA_STROKE
    private const val ALPHA_STROKE_TEXT = 0.8f * ALPHA_STROKE

    private const val BACKGROUND_COLOR = Color.BLACK

    fun getGamePadTheme(view: View): RadialGamePadTheme {
        return buildTheme(view)
    }

    private fun buildTheme(view: View): RadialGamePadTheme {
        val strokeSize = GraphicsUtils.getRawDpSize(view.context, R.dimen.touch_control_stroke_size)
        val colorOnSurface = MaterialColors.getColor(view, MaterialR.attr.colorOnSurface)
        val colorPrimary = MaterialColors.getColor(view, MaterialR.attr.colorPrimary)
        val colorSecondary = MaterialColors.getColor(view, MaterialR.attr.colorSecondary)

        return RadialGamePadTheme(
            normalColor = withAlpha(BACKGROUND_COLOR, ALPHA_FILL_STRONG),
            normalStrokeColor = withAlpha(colorOnSurface, ALPHA_STROKE_STRONG),
            backgroundColor = withAlpha(BACKGROUND_COLOR, ALPHA_FILL_LIGHT),
            backgroundStrokeColor = withAlpha(colorOnSurface, ALPHA_STROKE_LIGHT),
            pressedColor = withAlpha(colorPrimary, ALPHA_FILL_PRESSED),
            textColor = withAlpha(colorOnSurface, ALPHA_STROKE_TEXT),
            simulatedColor = withAlpha(colorSecondary, ALPHA_FILL_SIMULATED),
            lightColor = withAlpha(BACKGROUND_COLOR, ALPHA_FILL_STRONG),
            lightStrokeColor = withAlpha(colorOnSurface, ALPHA_STROKE_LIGHT),
            strokeWidthDp = strokeSize
        )
    }

    private fun withAlpha(color: Int, alpha: Float): Int {
        val alphaInt = (alpha * 255).toInt()
        return MaterialColors.compositeARGBWithAlpha(color, alphaInt)
    }
}
