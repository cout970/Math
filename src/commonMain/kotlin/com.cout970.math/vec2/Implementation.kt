@file:Suppress("FunctionName", "unused")

package com.cout970.math.vec2

// Private class, you should not depend on the implementation details
private class MutVec2fImpl(
    override var x: Float,
    override var y: Float
) : MutVec2f {

    override fun equals(other: Any?): Boolean {
        val vec = other as? Vec2 ?: return false
        if (this.xd != vec.xd) return false
        if (this.yd != vec.yd) return false
        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        return result
    }

    override fun toString(): String = "Vec2f($x, $y)"
}

// Private class, you should not depend on the implementation details
private class ImmVec2fImpl(
    override val x: Float,
    override val y: Float
) : ImmVec2f {
    override fun equals(other: Any?): Boolean {
        val vec = other as? Vec2 ?: return false
        if (this.xd != vec.xd) return false
        if (this.yd != vec.yd) return false
        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        return result
    }

    override fun toString(): String = "Vec2f($x, $y)"
}

// Vec2f constructors

fun ImmVec2f(x: Float = 0f, y: Float = 0f): ImmVec2f = ImmVec2fImpl(x, y)

fun ImmVec2f(xyz: Float): ImmVec2f = ImmVec2fImpl(xyz, xyz)

fun MutVec2f(x: Float = 0f, y: Float = 0f): MutVec2f = MutVec2fImpl(x, y)

fun MutVec2f(xyz: Float): MutVec2f = MutVec2fImpl(xyz, xyz)

// Private class, you should not depend on the implementation details
private class MutVec2iImpl(
    override var x: Int,
    override var y: Int
) : MutVec2i {
    override fun equals(other: Any?): Boolean {
        val vec = other as? Vec2 ?: return false
        // Equals must be the same with Vec2i.equals(Vec2f) and Vec2f.equals(Vec2i)
        if (this.xd != vec.xd) return false
        if (this.yd != vec.yd) return false
        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        return result
    }

    override fun toString(): String = "Vec2i($x, $y)"
}

// Private class, you should not depend on the implementation details
private class ImmVec2iImpl(
    override val x: Int,
    override val y: Int
) : ImmVec2i {
    override fun equals(other: Any?): Boolean {
        val vec = other as? Vec2 ?: return false
        // Equals must be the same with Vec2i.equals(Vec2f) and Vec2f.equals(Vec2i)
        if (this.xd != vec.xd) return false
        if (this.yd != vec.yd) return false
        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        return result
    }

    override fun toString(): String = "Vec2i($x, $y)"
}

// Vec2i constructors

fun ImmVec2i(x: Int = 0, y: Int = 0): ImmVec2i = ImmVec2iImpl(x, y)

fun ImmVec2i(xyz: Int): ImmVec2i = ImmVec2iImpl(xyz, xyz)

fun MutVec2i(x: Int = 0, y: Int = 0): MutVec2i = MutVec2iImpl(x, y)

fun MutVec2i(xyz: Int): MutVec2i = MutVec2iImpl(xyz, xyz)

// Private class, you should not depend on the implementation details
private class MutVec2dImpl(
    override var x: Double,
    override var y: Double
) : MutVec2d {
    override fun equals(other: Any?): Boolean {
        val vec = other as? Vec2 ?: return false
        if (this.xd != vec.xd) return false
        if (this.yd != vec.yd) return false
        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        return result
    }

    override fun toString(): String = "Vec2d($x, $y)"
}

// Private class, you should not depend on the implementation details
private class ImmVec2dImpl(
    override val x: Double,
    override val y: Double
) : ImmVec2d {
    override fun equals(other: Any?): Boolean {
        val vec = other as? Vec2 ?: return false
        if (this.xd != vec.xd) return false
        if (this.yd != vec.yd) return false
        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        return result
    }

    override fun toString(): String = "Vec2d($x, $y)"
}

// Vec2d constructors

fun ImmVec2d(x: Double = 0.0, y: Double = 0.0): ImmVec2d = ImmVec2dImpl(x, y)

fun ImmVec2d(xyz: Double): ImmVec2d = ImmVec2dImpl(xyz, xyz)

fun MutVec2d(x: Double = 0.0, y: Double = 0.0): MutVec2d = MutVec2dImpl(x, y)

fun MutVec2d(xyz: Double): MutVec2d = MutVec2dImpl(xyz, xyz)