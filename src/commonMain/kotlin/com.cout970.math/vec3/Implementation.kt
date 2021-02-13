@file:Suppress("FunctionName")

package com.cout970.math.vec3

// Private class, you should not depend on the implementation details
private class MutVec3fImpl(
    override var x: Float,
    override var y: Float,
    override var z: Float
) : MutVec3f {

    override fun equals(other: Any?): Boolean {
        val vec = other as? Vec3 ?: return false
        if (this.xd != vec.xd) return false
        if (this.yd != vec.yd) return false
        if (this.zd != vec.zd) return false
        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + z.hashCode()
        return result
    }

    override fun toString(): String = "Vec3f($x, $y, $z)"
}

// Private class, you should not depend on the implementation details
private class ImmVec3fImpl(
    override val x: Float,
    override val y: Float,
    override val z: Float
) : ImmVec3f {
    override fun equals(other: Any?): Boolean {
        val vec = other as? Vec3 ?: return false
        if (this.xd != vec.xd) return false
        if (this.yd != vec.yd) return false
        if (this.zd != vec.zd) return false
        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + z.hashCode()
        return result
    }

    override fun toString(): String = "Vec3f($x, $y, $z)"
}

// Vec3f constructors

fun ImmVec3f(x: Float = 0f, y: Float = 0f, z: Float = 0f): ImmVec3f = ImmVec3fImpl(x, y, z)

fun ImmVec3f(xyz: Float): ImmVec3f = ImmVec3fImpl(xyz, xyz, xyz)

fun MutVec3f(x: Float = 0f, y: Float = 0f, z: Float = 0f): MutVec3f = MutVec3fImpl(x, y, z)

fun MutVec3f(xyz: Float): MutVec3f = MutVec3fImpl(xyz, xyz, xyz)

// Private class, you should not depend on the implementation details
private class MutVec3iImpl(
    override var x: Int,
    override var y: Int,
    override var z: Int
) : MutVec3i {
    override fun equals(other: Any?): Boolean {
        val vec = other as? Vec3 ?: return false
        // Equals must be the same with Vec3i.equals(Vec3f) and Vec3f.equals(Vec3i)
        if (this.xd != vec.xd) return false
        if (this.yd != vec.yd) return false
        if (this.zd != vec.zd) return false
        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + z.hashCode()
        return result
    }

    override fun toString(): String = "Vec3i($x, $y, $z)"
}

// Private class, you should not depend on the implementation details
private class ImmVec3iImpl(
    override val x: Int,
    override val y: Int,
    override val z: Int
) : ImmVec3i {
    override fun equals(other: Any?): Boolean {
        val vec = other as? Vec3 ?: return false
        // Equals must be the same with Vec3i.equals(Vec3f) and Vec3f.equals(Vec3i)
        if (this.xd != vec.xd) return false
        if (this.yd != vec.yd) return false
        if (this.zd != vec.zd) return false
        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + z.hashCode()
        return result
    }

    override fun toString(): String = "Vec3i($x, $y, $z)"
}

// Vec3i constructors

fun ImmVec3i(x: Int = 0, y: Int = 0, z: Int = 0): ImmVec3i = ImmVec3iImpl(x, y, z)

fun ImmVec3i(xyz: Int): ImmVec3i = ImmVec3iImpl(xyz, xyz, xyz)

fun MutVec3i(x: Int = 0, y: Int = 0, z: Int = 0): MutVec3i = MutVec3iImpl(x, y, z)

fun MutVec3i(xyz: Int): MutVec3i = MutVec3iImpl(xyz, xyz, xyz)

// Private class, you should not depend on the implementation details
private class MutVec3dImpl(
    override var x: Double,
    override var y: Double,
    override var z: Double
) : MutVec3d {
    override fun equals(other: Any?): Boolean {
        val vec = other as? Vec3 ?: return false
        if (this.xd != vec.xd) return false
        if (this.yd != vec.yd) return false
        if (this.zd != vec.zd) return false
        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + z.hashCode()
        return result
    }

    override fun toString(): String = "Vec3d($x, $y, $z)"
}

// Private class, you should not depend on the implementation details
private class ImmVec3dImpl(
    override val x: Double,
    override val y: Double,
    override val z: Double
) : ImmVec3d {
    override fun equals(other: Any?): Boolean {
        val vec = other as? Vec3 ?: return false
        if (this.xd != vec.xd) return false
        if (this.yd != vec.yd) return false
        if (this.zd != vec.zd) return false
        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + z.hashCode()
        return result
    }

    override fun toString(): String = "Vec3d($x, $y, $z)"
}

// Vec3d constructors

fun ImmVec3d(x: Double = 0.0, y: Double = 0.0, z: Double = 0.0): ImmVec3d = ImmVec3dImpl(x, y, z)

fun ImmVec3d(xyz: Double): ImmVec3d = ImmVec3dImpl(xyz, xyz, xyz)

fun MutVec3d(x: Double = 0.0, y: Double = 0.0, z: Double = 0.0): MutVec3d = MutVec3dImpl(x, y, z)

fun MutVec3d(xyz: Double): MutVec3d = MutVec3dImpl(xyz, xyz, xyz)