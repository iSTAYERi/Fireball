package com.mygdx.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2


class Main: ApplicationAdapter() {
    private lateinit var batch: SpriteBatch
    private lateinit var fireballs: MutableList<SinSplitedTripleFireball>

    private lateinit var bmf: BitmapFont
    private lateinit var img: Texture

    override fun create() {
        batch = SpriteBatch()
        bmf = BitmapFont(
                Gdx.files.internal("myfont.fnt"),
                Gdx.files.internal("myfont.png"),
                false
        )
        img = Texture("badlogic.jpg")
        FireBall.texture = Texture("fireball.png")

        fireballs = mutableListOf(SinSplitedTripleFireball(
                position = Vector2(400f, 400f),
                velocity = Vector2(2f, 2f),
                direction = Vector2(100f, 100f)))
        fireballs.forEach { fireball -> fireball.create() }
    }

    override fun render() {
        update()
        Gdx.gl.glClearColor(200f/255, 220f/255, 200f/255, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.begin()
        fireballs.forEach { fireball -> fireball.render(batch) }
        bmf.draw(batch, "Hi, bitch!", 50f, 50f)
        bmf.draw(batch, "${Gdx.graphics.framesPerSecond} FPS", 50f, Gdx.graphics.height - 50f)
        batch.draw(img,
                InputHandler.getMousePosition().x - (img.width / 2),
                InputHandler.getMousePosition().y - (img.height / 2)
        )
        batch.end()
    }

    private fun update() {
        fireballs.forEach { fireball -> fireball.update() }
    }

    override fun dispose() {
        batch.dispose()
        fireballs.forEach { fireball -> fireball.dispose() }
    }
}