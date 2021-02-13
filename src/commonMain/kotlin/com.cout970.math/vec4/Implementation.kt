@file:Suppress("FunctionName", "unused")

package com.cout970.math.vec4

// Private class, you should not depend on the implementation details
private class MutVec4fImpl(
    override var x: Float,
    override var y: Float,
    override var z: Float,
    override var w: Float
) : MutVec4f {

    override fun equals(other: Any?): Boolean {
        val vec = other as? Vec4 ?: return false
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

    override fun toString(): String = "Vec4f($x, $y, $z, $w)"
}

// Private class, you should not depend on the implementation details
private class ImmVec4fImpl(
    override val x: Float,
    override val y: Float,
    override val z: Float,
    override val w: Float
) : ImmVec4f {
    override fun equals(other: Any?): Boolean {
        val vec = other as? Vec4 ?: return false
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

    override fun toString(): String = "Vec4f($x, $y, $z, $w)"
}

// Vec4f constructors

fun ImmVec4f(x: Float = 0f, y: Float = 0f, z: Float = 0f, w: Float = 0f): ImmVec4f = ImmVec4fImpl(x, y, z, w)

fun ImmVec4f(xyz: Float): ImmVec4f = ImmVec4fImpl(xyz, xyz, xyz, xyz)

fun MutVec4f(x: Float = 0f, y: Float = 0f, z: Float = 0f, w: Float = 0f): MutVec4f = MutVec4fImpl(x, y, z, w)

fun MutVec4f(xyz: Float): MutVec4f = MutVec4fImpl(xyz, xyz, xyz, xyz)

// Private class, you should not depend on the implementation details
private class MutVec4iImpl(
    override var x: Int,
    override var y: Int,
    override var z: Int,
    override var w: Int
) : MutVec4i {
    override fun equals(other: Any?): Boolean {
        val vec = other as? Vec4 ?: return false
        // Equals must be the same with Vec4i.equals(Vec4f) and Vec4f.equals(Vec4i)
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

    override fun toString(): String = "Vec4i($x, $y, $z, $w)"
}

// Private class, you should not depend on the implementation details
private class ImmVec4iImpl(
    override val x: Int,
    override val y: Int,
    override val z: Int,
    override val w: Int
) : ImmVec4i {
    override fun equals(other: Any?): Boolean {
        val vec = other as? Vec4 ?: return false
        // Equals must be the same with Vec4i.equals(Vec4f) and Vec4f.equals(Vec4i)
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

    override fun toString(): String = "Vec4i($x, $y, $z, $w)"
}

// Vec4i constructors

fun ImmVec4i(x: Int = 0, y: Int = 0, z: Int = 0, w: Int = 0): ImmVec4i = ImmVec4iImpl(x, y, z, w)

fun ImmVec4i(xyz: Int): ImmVec4i = ImmVec4iImpl(xyz, xyz, xyz, xyz)

fun MutVec4i(x: Int = 0, y: Int = 0, z: Int = 0, w: Int = 0): MutVec4i = MutVec4iImpl(x, y, z, w)

fun MutVec4i(xyz: Int): MutVec4i = MutVec4iImpl(xyz, xyz, xyz, xyz)

// Private class, you should not depend on the implementation details
private class MutVec4dImpl(
    override var x: Double,
    override var y: Double,
    override var z: Double,
    override var w: Double
) : MutVec4d {
    override fun equals(other: Any?): Boolean {
        val vec = other as? Vec4 ?: return false
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

    override fun toString(): String = "Vec4d($x, $y, $z, $w)"
}

// Private class, you should not depend on the implementation details
private class ImmVec4dImpl(
    override val x: Double,
    override val y: Double,
    override val z: Double,
    override val w: Double
) : ImmVec4d {
    override fun equals(other: Any?): Boolean {
        val vec = other as? Vec4 ?: return false
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

    override fun toString(): String = "Vec4d($x, $y, $z, $w)"
}

// Vec4d constructors

fun ImmVec4d(x: Double = 0.0, y: Double = 0.0, z: Double = 0.0, w: Double = 0.0): ImmVec4d = ImmVec4dImpl(x, y, z, w)

fun ImmVec4d(xyz: Double): ImmVec4d = ImmVec4dImpl(xyz, xyz, xyz, xyz)

fun MutVec4d(x: Double = 0.0, y: Double = 0.0, z: Double = 0.0, w: Double = 0.0): MutVec4d = MutVec4dImpl(x, y, z, w)

fun MutVec4d(xyz: Double): MutVec4d = MutVec4dImpl(xyz, xyz, xyz, xyz)