package com.cout970.math.vec3

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
interface Vec3 {
    // Get values as floats, cast if necessary
    val xf: Float
    val yf: Float
    val zf: Float

    // Get values as ints, cast if necessary
    val xi: Int
    val yi: Int
    val zi: Int

    // Get values as double, cast if necessary
    val xd: Double
    val yd: Double
    val zd: Double

    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    override fun toString(): String
}

/**
 * Mutable marker for 3D vectors
 * The underling implementation is guaranteed to be mutable
 */
interface MutVec3 : Vec3

/**
 * Immutable marker for 3D vectors
 * The underling implementation is guaranteed to be immutable
 *
 * Usually functions will work with Vec3 if they don't need to mutate the vector and
 * with classes will store ImmVec3 to make sure the underlying values don't change unexpectedly
 */
interface ImmVec3 : Vec3

// Readonly, 3D vector of floats
interface Vec3f : Vec3, Comparable<Vec3f> {
    val x: Float
    val y: Float
    val z: Float

    override val xf: Float get() = x
    override val yf: Float get() = y
    override val zf: Float get() = z
    override val xi: Int get() = x.toInt()
    override val yi: Int get() = y.toInt()
    override val zi: Int get() = z.toInt()
    override val xd: Double get() = x.toDouble()
    override val yd: Double get() = y.toDouble()
    override val zd: Double get() = z.toDouble()

    override fun compareTo(other: Vec3f): Int {
        val compX = this.x.compareTo(other.x)
        val compY = this.y.compareTo(other.y)
        val compZ = this.z.compareTo(other.z)

        return when {
            compX != 0 -> compX
            compY != 0 -> compY
            compZ != 0 -> compZ
            else -> 0
        }
    }
}

// Readonly, 3D vector of ints
interface Vec3i : Vec3, Comparable<Vec3i> {
    val x: Int
    val y: Int
    val z: Int

    override val xf: Float get() = x.toFloat()
    override val yf: Float get() = y.toFloat()
    override val zf: Float get() = z.toFloat()
    override val xi: Int get() = x
    override val yi: Int get() = y
    override val zi: Int get() = z
    override val xd: Double get() = x.toDouble()
    override val yd: Double get() = y.toDouble()
    override val zd: Double get() = z.toDouble()

    override fun compareTo(other: Vec3i): Int {
        val compX = this.x.compareTo(other.x)
        val compY = this.y.compareTo(other.y)
        val compZ = this.z.compareTo(other.z)

        return when {
            compX != 0 -> compX
            compY != 0 -> compY
            compZ != 0 -> compZ
            else -> 0
        }
    }
}

// Readonly, 3D vector of doubles
interface Vec3d : Vec3, Comparable<Vec3d> {
    val x: Double
    val y: Double
    val z: Double

    override val xf: Float get() = x.toFloat()
    override val yf: Float get() = y.toFloat()
    override val zf: Float get() = z.toFloat()
    override val xi: Int get() = x.toInt()
    override val yi: Int get() = y.toInt()
    override val zi: Int get() = z.toInt()
    override val xd: Double get() = x
    override val yd: Double get() = y
    override val zd: Double get() = z

    override fun compareTo(other: Vec3d): Int {
        val compX = this.x.compareTo(other.x)
        val compY = this.y.compareTo(other.y)
        val compZ = this.z.compareTo(other.z)

        return when {
            compX != 0 -> compX
            compY != 0 -> compY
            compZ != 0 -> compZ
            else -> 0
        }
    }
}

// Mutable 3D vector of floats
interface MutVec3f : MutVec3, Vec3f {
    override var x: Float
    override var y: Float
    override var z: Float
}

// Mutable 3D vector of ints
interface MutVec3i : MutVec3, Vec3i {
    override var x: Int
    override var y: Int
    override var z: Int
}

// Mutable 3D vector of doubles
interface MutVec3d : MutVec3, Vec3d {
    override var x: Double
    override var y: Double
    override var z: Double
}

// Immutable 3D vector of floats
// It's guaranteed that it will never change
interface ImmVec3f : ImmVec3, Vec3f

// Immutable 3D vector of ints
// It's guaranteed that it will never change
interface ImmVec3i : ImmVec3, Vec3i

// Immutable 3D vector of doubles
// It's guaranteed that it will never change
interface ImmVec3d : ImmVec3, Vec3d