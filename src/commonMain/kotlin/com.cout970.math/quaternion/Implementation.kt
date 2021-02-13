@file:Suppress("FunctionName", "unused")

package com.cout970.math.quaternion

import kotlin.math.sqrt

// Private class, you should not depend on the implementation details
private class MutQuatfImpl(
    override var x: Float,
    override var y: Float,
    override var z: Float,
    override var w: Float
) : MutQuatf {

    override fun equals(other: Any?): Boolean {
        val vec = other as? Quat ?: return false
        if (this.xd != vec.xd) return false
        if (this.yd != vec.yd) return false
        if (this.zd != vec.zd) return false
        if (this.wd != vec.wd) return false
        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + z.hashCode()
        result = 31 * result + w.hashCode()
        return result
    }

    override fun toString(): String = "Quatf($x, $y, $z, $w)"
}

// Private class, you should not depend on the implementation details
private class ImmQuatfImpl(
    override val x: Float,
    override val y: Float,
    override val z: Float,
    override val w: Float
) : ImmQuatf {
    override fun equals(other: Any?): Boolean {
        val vec = other as? Quat ?: return false
        if (this.xd != vec.xd) return false
        if (this.yd != vec.yd) return false
        if (this.zd != vec.zd) return false
        if (this.wd != vec.wd) return false
        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + z.hashCode()
        result = 31 * result + w.hashCode()
        return result
    }

    override fun toString(): String = "Quatf($x, $y, $z, $w)"
}

// Quatf constructors

fun ImmQuatf(x: Float = 0f, y: Float = 0f, z: Float = 0f, w: Float = 1f): ImmQuatf {
    val invSqrt = 1 / sqrt(x * x + y * y + z * z + w * w)
    return ImmQuatfImpl(x * invSqrt, y * invSqrt, z * invSqrt, w * invSqrt)
}

fun MutQuatf(x: Float = 0f, y: Float = 0f, z: Float = 0f, w: Float = 1f): MutQuatf {
    val invSqrt = 1 / sqrt(x * x + y * y + z * z + w * w)
    return MutQuatfImpl(x * invSqrt, y * invSqrt, z * invSqrt, w * invSqrt)
}

// Private class, you should not depend on the implementation details
private class MutQuatdImpl(
    override var x: Double,
    override var y: Double,
    override var z: Double,
    override var w: Double
) : MutQuatd {
    override fun equals(other: Any?): Boolean {
        val vec = other as? Quat ?: return false
        if (this.xd != vec.xd) return false
        if (this.yd != vec.yd) return false
        if (this.zd != vec.zd) return false
        if (this.wd != vec.wd) return false
        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + z.hashCode()
        result = 31 * result + w.hashCode()
        return result
    }

    override fun toString(): String = "Quatd($x, $y, $z, $w)"
}

// Private class, you should not depend on the implementation details
private class ImmQuatdImpl(
    override val x: Double,
    override val y: Double,
    override val z: Double,
    override val w: Double
) : ImmQuatd {
    override fun equals(other: Any?): Boolean {
        val vec = other as? Quat ?: return false
        if (this.xd != vec.xd) return false
        if (this.yd != vec.yd) return false
        if (this.zd != vec.zd) return false
        if (this.wd != vec.wd) return false
        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + z.hashCode()
        result = 31 * result + w.hashCode()
        return result
    }

    override fun toString(): String = "Quatd($x, $y, $z, $w)"
}

// Quatd constructors

fun ImmQuatd(x: Double = 0.0, y: Double = 0.0, z: Double = 0.0, w: Double = 1.0): ImmQuatd {
    val invSqrt = 1 / sqrt(x * x + y * y + z * z + w * w)
    return ImmQuatdImpl(x * invSqrt, y * invSqrt, z * invSqrt, w * invSqrt)
}

fun MutQuatd(x: Double = 0.0, y: Double = 0.0, z: Double = 0.0, w: Double = 1.0): MutQuatd {
    val invSqrt = 1 / sqrt(x * x + y * y + z * z + w * w)
    return MutQuatdImpl(x * invSqrt, y * invSqrt, z * invSqrt, w * invSqrt)
}