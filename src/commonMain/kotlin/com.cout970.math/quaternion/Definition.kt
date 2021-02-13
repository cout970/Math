package com.cout970.math.quaternion

/*
 * Readonly, type agnostic version of quaternion
 * The underling implementation could be mutable or immutable
 *
 * Quaternions are commonly used to represent rotations in a 3D space,
 * a lot of utilities are provided so you don't need to understand the mechanisms that make them work,
 * you can think of then like magic black boxes that can store and apply 3D rotations
 *
 * Provides efficient primitive type getters
 *
 * Notes:
 * - You are free to implement this interface on your own quaternions and quaternion-like classes
 * - equals() implementation must only compare the values, the implementing class must be ignored
 *
 * Implementation note:
 *  Using `x: Number` would cause extra boxing of primitive values and
 *  should be avoided as much as possible, except for inline function parameters where the
 *  compiler can optimize boxing
*/
interface Quat {
    // Get values as floats, cast if necessary
    val xf: Float
    val yf: Float
    val zf: Float
    val wf: Float

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
 * Mutable marker for quaternions
 * The underling implementation is guaranteed to be mutable
 */
interface MutQuat : Quat

/**
 * Immutable marker for quaternions
 * The underling implementation is guaranteed to be immutable
 *
 * Usually functions will work with Quat if they don't need to mutate the quaternion and
 * with classes will store ImmQuat to make sure the underlying values don't change unexpectedly
 */
interface ImmQuat : Quat

// Readonly, quaternion of floats
interface Quatf : Quat, Comparable<Quatf> {
    val x: Float
    val y: Float
    val z: Float
    val w: Float

    override val xf: Float get() = x
    override val yf: Float get() = y
    override val zf: Float get() = z
    override val wf: Float get() = w
    override val xd: Double get() = x.toDouble()
    override val yd: Double get() = y.toDouble()
    override val zd: Double get() = z.toDouble()
    override val wd: Double get() = w.toDouble()

    override fun compareTo(other: Quatf): Int {
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

// Readonly, quaternion of doubles
interface Quatd : Quat, Comparable<Quatd> {
    val x: Double
    val y: Double
    val z: Double
    val w: Double

    override val xf: Float get() = x.toFloat()
    override val yf: Float get() = y.toFloat()
    override val zf: Float get() = z.toFloat()
    override val wf: Float get() = w.toFloat()
    override val xd: Double get() = x
    override val yd: Double get() = y
    override val zd: Double get() = z
    override val wd: Double get() = w

    override fun compareTo(other: Quatd): Int {
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

// Mutable quaternion of floats
interface MutQuatf : MutQuat, Quatf {
    override var x: Float
    override var y: Float
    override var z: Float
    override var w: Float
}

// Mutable quaternion of doubles
interface MutQuatd : MutQuat, Quatd {
    override var x: Double
    override var y: Double
    override var z: Double
    override var w: Double
}

// Immutable quaternion of floats
// It's guaranteed that it will never change
interface ImmQuatf : ImmQuat, Quatf

// Immutable quaternion of doubles
// It's guaranteed that it will never change
interface ImmQuatd : ImmQuat, Quatd