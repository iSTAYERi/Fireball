package com.mygdx.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2


class FireBall(var position: Vector2, var velocity: Vector2): GameObject {

    companion object {
        lateinit var texture: Texture
    }

    override fun create() {

    }

    override fun render(batch: SpriteBatch) {
        batch.draw(texture,
                position.x - (texture.width / 2) ,
                position.y - (texture.height / 2)
        )
    }

    override fun update() {
        if(InputHandler.isPressed()) {
            if (position.cpy().sub(InputHandler.getMousePosition()).len() < 300 ) {
                velocity = position.cpy().sub(InputHandler.getMousePosition()).nor().scl(8f)
            }
        }
        velocity.scl(0.99f)

        position.add(velocity)

        // Обработка отражения от краев экрана
        if (position.x > Gdx.graphics.width) {
            velocity.x = -velocity.x
            position.x = Gdx.graphics.width.toFloat()
        }
        if (position.x < 0) {
            velocity.x = -velocity.x
            position.x = 0f
        }
        if (position.y > Gdx.graphics.height) {
            velocity.y = -velocity.y
            position.y = Gdx.graphics.height.toFloat()
        }
        if (position.y < 0) {
            velocity.y = -velocity.y
            position.y = 0f
        }
    }

    fun updatePosition(positionNew: Vector2) {
        position = positionNew
    }

    override fun dispose() {
        texture.dispose()
    }
}