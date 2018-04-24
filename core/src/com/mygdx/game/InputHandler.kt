package com.mygdx.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.math.Vector2


class InputHandler {

    companion object {
        fun isClicked(): Boolean {
            return Gdx.input.justTouched()
        }

        fun isPressed(): Boolean {
            return Gdx.input.isTouched
        }

        fun getMousePosition(): Vector2 {
            return Vector2(Gdx.input.x.toFloat(), (Gdx.graphics.height - Gdx.input.y).toFloat())
        }
    }

}