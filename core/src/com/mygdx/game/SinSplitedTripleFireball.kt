package com.mygdx.game

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import kotlin.math.sin


class SinSplitedTripleFireball(
        private var position: Vector2,
        private var velocity: Vector2,
        private var direction: Vector2): GameObject {

    lateinit var centerFireBall: FireBall
    lateinit var sinFireBall: FireBall
    lateinit var cosFireBall: FireBall

    var sinX = 0f
    var sinY = 0f
    val angle = velocity.angle()

    override fun create() {
        velocity.rotate(90f)
        centerFireBall = FireBall(position.cpy(), velocity.cpy())
        sinFireBall = FireBall(position.cpy(), velocity.cpy())
        cosFireBall = FireBall(position.cpy(), velocity.cpy())
    }

    override fun render(batch: SpriteBatch) {
        centerFireBall.render(batch)
        sinFireBall.render(batch)
        cosFireBall.render(batch)
    }

    override fun update() {
        centerFireBall.position.add(velocity)
        sinX = velocity.cpy().x
        sinY = 10 * sin(sinFireBall.position.cpy().x / 20f)
        sinFireBall.position.add(sinX, sinY)
        cosFireBall.position.add(sinX, -sinY)
    }

    override fun dispose() {
        centerFireBall.dispose()
        sinFireBall.dispose()
        cosFireBall.dispose()
    }
}