package com.mygdx.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import java.util.*


class Main: ApplicationAdapter() {
    private lateinit var batch: SpriteBatch
    private lateinit var fireball: FireBall
    private var random = Random()

    private lateinit var bmf: BitmapFont
    private lateinit var img: Texture

    companion object {
        private const val ASTEROIDS_COUNT = 200
    }

    override fun create() {
        batch = SpriteBatch()
        bmf = BitmapFont(
                Gdx.files.internal("myfont.fnt"),
                Gdx.files.internal("myfont.png"),
                false
        )
        img = Texture("badlogic.jpg")
        FireBall.texture = Texture("fireball.png")
        fireball = FireBall(Vector2(random.nextInt(Gdx.graphics.width).toFloat(),
                random.nextInt(Gdx.graphics.height).toFloat()),
                Vector2(10 * (random.nextFloat() - 0.5f),
                        3 * (random.nextFloat() - 0.5f)))
        fireball.create()
    }

    override fun render() {
        update()
        Gdx.gl.glClearColor(200f/255, 220f/255, 200f/255, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch.begin()
        fireball.render(batch)
        bmf.draw(batch, "Hello, my friend!", 50f, 50f)
        bmf.draw(batch, "${Gdx.graphics.framesPerSecond} FPS", 50f, Gdx.graphics.height - 50f)
        batch.draw(img,
                InputHandler.getMousePosition().x - (img.width / 2),
                InputHandler.getMousePosition().y - (img.height / 2)
        )
        batch.end()
    }

    private fun update() {
        fireball.update()
    }

    override fun dispose() {
        batch.dispose()
        fireball.dispose()
    }
}