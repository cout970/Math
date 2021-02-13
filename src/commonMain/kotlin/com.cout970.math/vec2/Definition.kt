package com.cout970.math.vec2

/*
 * Readonly, type agnostic version of 2D vector
 * The underling implementation could be mutable or immutable
 *
 * Provides efficient primitive type getters
 *
 * Notes:
 * - You are free to implement this interface on your own vectors and vector-like classes
 * - equals() implementation must only compare the values, the implementing class must be ignored
 *
 * Implementation note:
 *  Using `x: Number` would cause extra boxing of primitive values and
 *  should be avoided as much as possible, except for inline function parameters where the
 *  compiler can optimize boxing
*/
interface Vec2 {
    // Get values as floats, cast if necessary
    val xf: Float
    val yf: Float

    // Get values as ints, cast if necessary
    val xi: Int
    val yi: Int

    // Get values as double, cast if necessary
    val xd: Double
    val yd: Double

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String
}

/**
 * Mutable marker for 2D vectors
 * The underling implementation is guaranteed to be mutable
 */
interface MutVec2 : Vec2

/**
 * Immutable marker for 2D vectors
 * The underling implementation is guaranteed to be immutable
 *
 * Usually functions will work with Vec2 if they don't need to mutate the vector and
 * with classes will store ImmVec2 to make sure the underlying values don't change unexpectedly
 */
interface ImmVec2 : Vec2

// Readonly, 2D vector of floats
interface Vec2f : Vec2, Comparable<Vec2f> {
    val x: Float
    val y: Float

    override val xf: Float get() = x
    override val yf: Float get() = y
    override val xi: Int get() = x.toInt()
    override val yi: Int get() = y.toInt()
    override val xd: Double get() = x.toDouble()
    override val yd: Double get() = y.toDouble()

    override fun compareTo(other: Vec2f): Int {
        val compX = this.x.compareTo(other.x)
        val compY = this.y.compareTo(other.y)

        return when {
            compX != 0 -> compX
            compY != 0 -> compY
            else -> 0
        }
    }
}

// Readonly, 2D vector of ints
interface Vec2i : Vec2, Comparable<Vec2i> {
    val x: Int
    val y: Int

    override val xf: Float get() = x.toFloat()
    override val yf: Float get() = y.toFloat()
    override val xi: Int get() = x
    override val yi: Int get() = y
    override val xd: Double get() = x.toDouble()
    override val yd: Double get() = y.toDouble()

    override fun compareTo(other: Vec2i): Int {
        val compX = this.x.compareTo(other.x)
        val compY = this.y.compareTo(other.y)

        return when {
            compX != 0 -> compX
            compY != 0 -> compY
            else -> 0
        }
    }
}

// Readonly, 2D vector of doubles
interface Vec2d : Vec2, Comparable<Vec2d> {
    val x: Double
    val y: Double

    override val xf: Float get() = x.toFloat()
    override val yf: Float get() = y.toFloat()
    override val xi: Int get() = x.toInt()
    override val yi: Int get() = y.toInt()
    override val xd: Double get() = x
    override val yd: Double get() = y

    override fun compareTo(other: Vec2d): Int {
        val compX = this.x.compareTo(other.x)
        val compY = this.y.compareTo(other.y)

        return when {
            compX != 0 -> compX
            compY != 0 -> compY
            else -> 0
        }
    }
}

// Mutable 2D vector of floats
interface MutVec2f : MutVec2, Vec2f {
    override var x: Float
    override var y: Float
}

// Mutable 2D vector of ints
interface MutVec2i : MutVec2, Vec2i {
    override var x: Int
    override var y: Int
}

// Mutable 2D vector of doubles
interface MutVec2d : MutVec2, Vec2d {
    override var x: Double
    override var y: Double
}

// Immutable 2D vector of floats
// It's guaranteed that it will never change
interface ImmVec2f : ImmVec2, Vec2f

// Immutable 2D vector of ints
// It's guaranteed that it will never change
interface ImmVec2i : ImmVec2, Vec2i

// Immutable 2D vector of doubles
// It's guaranteed that it will never change
interface ImmVec2d : ImmVec2, Vec2d