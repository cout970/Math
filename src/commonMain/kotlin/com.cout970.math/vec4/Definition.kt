package com.cout970.math.vec4

/*
 * Readonly, type agnostic version of 3D vector
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
interface Vec4 {
    // Get values as floats, cast if necessary
    val xf: Float
    val yf: Float
    val zf: Float
    val wf: Float

    // Get values as ints, cast if necessary
    val xi: Int
    val yi: Int
    val zi: Int
    val wi: Int

    // Get values as double, cast if necessary
    val xd: Double
    val yd: Double
    val zd: Double
    val wd: Double

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String
}

/**
 * Mutable marker for 4D vectors
 * The underling implementation is guaranteed to be mutable
 */
interface MutVec4 : Vec4

/**
 * Immutable marker for 4D vectors
 * The underling implementation is guaranteed to be immutable
 *
 * Usually functions will work with Vec4 if they don't need to mutate the vector and
 * with classes will store ImmVec4 to make sure the underlying values don't change unexpectedly
 */
interface ImmVec4 : Vec4

// Readonly, 4D vector of floats
interface Vec4f : Vec4, Comparable<Vec4f> {
    val x: Float
    val y: Float
    val z: Float
    val w: Float

    override val xf: Float get() = x
    override val yf: Float get() = y
    override val zf: Float get() = z
    override val wf: Float get() = w
    override val xi: Int get() = x.toInt()
    override val yi: Int get() = y.toInt()
    override val zi: Int get() = z.toInt()
    override val wi: Int get() = w.toInt()
    override val xd: Double get() = x.toDouble()
    override val yd: Double get() = y.toDouble()
    override val zd: Double get() = z.toDouble()
    override val wd: Double get() = w.toDouble()

    override fun compareTo(other: Vec4f): Int {
        val compX = this.x.compareTo(other.x)
        val compY = this.y.compareTo(other.y)
        val compZ = this.z.compareTo(other.z)
        val compW = this.w.compareTo(other.w)

        return when {
            compX != 0 -> compX
            compY != 0 -> compY
            compZ != 0 -> compZ
            compW != 0 -> compW
            else -> 0
        }
    }
}

// Readonly, 4D vector of ints
interface Vec4i : Vec4, Comparable<Vec4i> {
    val x: Int
    val y: Int
    val z: Int
    val w: Int

    override val xf: Float get() = x.toFloat()
    override val yf: Float get() = y.toFloat()
    override val zf: Float get() = z.toFloat()
    override val wf: Float get() = w.toFloat()
    override val xi: Int get() = x
    override val yi: Int get() = y
    override val zi: Int get() = z
    override val wi: Int get() = w
    override val xd: Double get() = x.toDouble()
    override val yd: Double get() = y.toDouble()
    override val zd: Double get() = z.toDouble()
    override val wd: Double get() = w.toDouble()

    override fun compareTo(other: Vec4i): Int {
        val compX = this.x.compareTo(other.x)
        val compY = this.y.compareTo(other.y)
        val compZ = this.z.compareTo(other.z)
        val compW = this.w.compareTo(other.w)

        return when {
            compX != 0 -> compX
            compY != 0 -> compY
            compZ != 0 -> compZ
            compW != 0 -> compW
            else -> 0
        }
    }
}

// Readonly, 4D vector of doubles
interface Vec4d : Vec4, Comparable<Vec4d> {
    val x: Double
    val y: Double
    val z: Double
    val w: Double

    override val xf: Float get() = x.toFloat()
    override val yf: Float get() = y.toFloat()
    override val zf: Float get() = z.toFloat()
    override val wf: Float get() = w.toFloat()
    override val xi: Int get() = x.toInt()
    override val yi: Int get() = y.toInt()
    override val zi: Int get() = z.toInt()
    override val wi: Int get() = w.toInt()
    override val xd: Double get() = x
    override val yd: Double get() = y
    override val zd: Double get() = z
    override val wd: Double get() = w

    override fun compareTo(other: Vec4d): Int {
        val compX = this.x.compareTo(other.x)
        val compY = this.y.compareTo(other.y)
        val compZ = this.z.compareTo(other.z)
        val compW = this.w.compareTo(other.w)

        return when {
            compX != 0 -> compX
            compY != 0 -> compY
            compZ != 0 -> compZ
            compW != 0 -> compW
            else -> 0
        }
    }
}

// Mutable 4D vector of floats
interface MutVec4f : MutVec4, Vec4f {
    override var x: Float
    override var y: Float
    override var z: Float
    override var w: Float
}

// Mutable 4D vector of ints
interface MutVec4i : MutVec4, Vec4i {
    override var x: Int
    override var y: Int
    override var z: Int
    override var w: Int
}

// Mutable 4D vector of doubles
interface MutVec4d : MutVec4, Vec4d {
    override var x: Double
    override var y: Double
    override var z: Double
    override var w: Double
}

// Immutable 4D vector of floats
// It's guaranteed that it will never change
interface ImmVec4f : ImmVec4, Vec4f

// Immutable 4D vector of ints
// It's guaranteed that it will never change
interface ImmVec4i : ImmVec4, Vec4i

// Immutable 4D vector of doubles
// It's guaranteed that it will never change
interface ImmVec4d : ImmVec4, Vec4d