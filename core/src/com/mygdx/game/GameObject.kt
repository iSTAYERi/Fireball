package com.mygdx.game

import com.badlogic.gdx.graphics.g2d.SpriteBatch


interface GameObject {

    fun create()
    fun render(batch: SpriteBatch)
    fun update()
    fun dispose()

}