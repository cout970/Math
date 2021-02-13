@file:Suppress("NOTHING_TO_INLINE", "unused")

package com.cout970.math.vec3

import kotlin.math.absoluteValue
import kotlin.math.acos
import kotlin.math.sqrt

/**
 * Note: all utilities are implemented as extensions for the following reasons:
 * - Extensions use static dispatch avoiding the cost of virtual methods
 * - Allows to reuse the utilities with new implementations of the base interfaces
 * - Allows to put together functions with the same name and behaviour but with different argument types
 * - Allows to use import alias to rename functions, ej `import math.vec3.length as norm`
 */

// plus: a + b

operator fun Vec3f.plus(other: Vec3): ImmVec3f {
    return ImmVec3f(this.x + other.xf, this.y + other.yf, this.z + other.zf)
}

operator fun Vec3i.plus(other: Vec3): ImmVec3i {
    return ImmVec3i(this.x + other.xi, this.y + other.yi, this.z + other.zi)
}

operator fun Vec3d.plus(other: Vec3): ImmVec3d {
    return ImmVec3d(this.x + other.xd, this.y + other.yd, this.z + other.zd)
}

inline operator fun Vec3f.plus(other: Number): ImmVec3f {
    return ImmVec3f(this.x + other.toFloat(), this.y + other.toFloat(), this.z + other.toFloat())
}

inline operator fun Vec3i.plus(other: Number): ImmVec3i {
    return ImmVec3i(this.x + other.toInt(), this.y + other.toInt(), this.z + other.toInt())
}

inline operator fun Vec3d.plus(other: Number): ImmVec3d {
    return ImmVec3d(this.x + other.toDouble(), this.y + other.toDouble(), this.z + other.toDouble())
}

operator fun MutVec3f.plusAssign(other: Vec3) {
    this.x = this.x + other.xf
    this.y = this.y + other.yf
    this.z = this.z + other.zf
}

operator fun MutVec3i.plusAssign(other: Vec3) {
    this.x = this.x + other.xi
    this.y = this.y + other.yi
    this.z = this.z + other.zi
}

operator fun MutVec3d.plusAssign(other: Vec3) {
    this.x = this.x + other.xd
    this.y = this.y + other.yd
    this.z = this.z + other.zd
}

// minus: a - b

operator fun Vec3f.minus(other: Vec3): ImmVec3f {
    return ImmVec3f(this.x - other.xf, this.y - other.yf, this.z - other.zf)
}

operator fun Vec3i.minus(other: Vec3): ImmVec3i {
    return ImmVec3i(this.x - other.xi, this.y - other.yi, this.z - other.zi)
}

operator fun Vec3d.minus(other: Vec3): ImmVec3d {
    return ImmVec3d(this.x - other.xd, this.y - other.yd, this.z - other.zd)
}

inline operator fun Vec3f.minus(other: Number): ImmVec3f {
    return ImmVec3f(this.x - other.toFloat(), this.y - other.toFloat(), this.z - other.toFloat())
}

inline operator fun Vec3i.minus(other: Number): ImmVec3i {
    return ImmVec3i(this.x - other.toInt(), this.y - other.toInt(), this.z - other.toInt())
}

inline operator fun Vec3d.minus(other: Number): ImmVec3d {
    return ImmVec3d(this.x - other.toDouble(), this.y - other.toDouble(), this.z - other.toDouble())
}

operator fun MutVec3f.minusAssign(other: Vec3) {
    this.x = this.x - other.xf
    this.y = this.y - other.yf
    this.z = this.z - other.zf
}

operator fun MutVec3i.minusAssign(other: Vec3) {
    this.x = this.x - other.xi
    this.y = this.y - other.yi
    this.z = this.z - other.zi
}

operator fun MutVec3d.minusAssign(other: Vec3) {
    this.x = this.x - other.xd
    this.y = this.y - other.yd
    this.z = this.z - other.zd
}

// unary minus: -a

inline operator fun Vec3f.unaryMinus(): ImmVec3f {
    return ImmVec3f(-x, -y, -z)
}

inline operator fun Vec3i.unaryMinus(): ImmVec3i {
    return ImmVec3i(-x, -y, -z)
}

inline operator fun Vec3d.unaryMinus(): ImmVec3d {
    return ImmVec3d(-x, -y, -z)
}

// unary plus: +a

inline operator fun Vec3f.unaryPlus(): ImmVec3f {
    return ImmVec3f(+x, +y, +z)
}

inline operator fun Vec3i.unaryPlus(): ImmVec3i {
    return ImmVec3i(+x, +y, +z)
}

inline operator fun Vec3d.unaryPlus(): ImmVec3d {
    return ImmVec3d(+x, +y, +z)
}

// times: a * b

operator fun Vec3f.times(other: Vec3): ImmVec3f {
    return ImmVec3f(this.x * other.xf, this.y * other.yf, this.z * other.zf)
}

operator fun Vec3i.times(other: Vec3): ImmVec3i {
    return ImmVec3i(this.x * other.xi, this.y * other.yi, this.z * other.zi)
}

operator fun Vec3d.times(other: Vec3): ImmVec3d {
    return ImmVec3d(this.x * other.xd, this.y * other.yd, this.z * other.zd)
}

inline operator fun Vec3f.times(other: Number): ImmVec3f {
    return ImmVec3f(this.x * other.toFloat(), this.y * other.toFloat(), this.z * other.toFloat())
}

inline operator fun Vec3i.times(other: Number): ImmVec3i {
    return ImmVec3i(this.x * other.toInt(), this.y * other.toInt(), this.z * other.toInt())
}

inline operator fun Vec3d.times(other: Number): ImmVec3d {
    return ImmVec3d(this.x * other.toDouble(), this.y * other.toDouble(), this.z * other.toDouble())
}

operator fun MutVec3f.timesAssign(other: Vec3) {
    this.x = this.x * other.xf
    this.y = this.y * other.yf
    this.z = this.z * other.zf
}

operator fun MutVec3i.timesAssign(other: Vec3) {
    this.x = this.x * other.xi
    this.y = this.y * other.yi
    this.z = this.z * other.zi
}

operator fun MutVec3d.timesAssign(other: Vec3) {
    this.x = this.x * other.xd
    this.y = this.y * other.yd
    this.z = this.z * other.zd
}

// div: a / b

operator fun Vec3f.div(other: Vec3): ImmVec3f {
    return ImmVec3f(this.x / other.xf, this.y / other.yf, this.z / other.zf)
}

operator fun Vec3i.div(other: Vec3): ImmVec3i {
    return ImmVec3i(this.x / other.xi, this.y / other.yi, this.z / other.zi)
}

operator fun Vec3d.div(other: Vec3): ImmVec3d {
    return ImmVec3d(this.x / other.xd, this.y / other.yd, this.z / other.zd)
}

inline operator fun Vec3f.div(other: Number): ImmVec3f {
    return ImmVec3f(this.x / other.toFloat(), this.y / other.toFloat(), this.z / other.toFloat())
}

inline operator fun Vec3i.div(other: Number): ImmVec3i {
    return ImmVec3i(this.x / other.toInt(), this.y / other.toInt(), this.z / other.toInt())
}

inline operator fun Vec3d.div(other: Number): ImmVec3d {
    return ImmVec3d(this.x / other.toDouble(), this.y / other.toDouble(), this.z / other.toDouble())
}

operator fun MutVec3f.divAssign(other: Vec3) {
    this.x = this.x / other.xf
    this.y = this.y / other.yf
    this.z = this.z / other.zf
}

operator fun MutVec3i.divAssign(other: Vec3) {
    this.x = this.x / other.xi
    this.y = this.y / other.yi
    this.z = this.z / other.zi
}

operator fun MutVec3d.divAssign(other: Vec3) {
    this.x = this.x / other.xd
    this.y = this.y / other.yd
    this.z = this.z / other.zd
}

// rem: a % b

operator fun Vec3f.rem(other: Vec3): ImmVec3f {
    return ImmVec3f(this.x % other.xf, this.y % other.yf, this.z % other.zf)
}

operator fun Vec3i.rem(other: Vec3): ImmVec3i {
    return ImmVec3i(this.x % other.xi, this.y % other.yi, this.z % other.zi)
}

operator fun Vec3d.rem(other: Vec3): ImmVec3d {
    return ImmVec3d(this.x % other.xd, this.y % other.yd, this.z % other.zd)
}

inline operator fun Vec3f.rem(other: Number): ImmVec3f {
    return ImmVec3f(this.x % other.toFloat(), this.y % other.toFloat(), this.z % other.toFloat())
}

inline operator fun Vec3i.rem(other: Number): ImmVec3i {
    return ImmVec3i(this.x % other.toInt(), this.y % other.toInt(), this.z % other.toInt())
}

inline operator fun Vec3d.rem(other: Number): ImmVec3d {
    return ImmVec3d(this.x % other.toDouble(), this.y % other.toDouble(), this.z % other.toDouble())
}

operator fun MutVec3f.remAssign(other: Vec3) {
    this.x = this.x % other.xf
    this.y = this.y % other.yf
    this.z = this.z % other.zf
}

operator fun MutVec3i.remAssign(other: Vec3) {
    this.x = this.x % other.xi
    this.y = this.y % other.yi
    this.z = this.z % other.zi
}

operator fun MutVec3d.remAssign(other: Vec3) {
    this.x = this.x % other.xd
    this.y = this.y % other.yd
    this.z = this.z % other.zd
}

// Conversions

fun Vec3.toImmVec3f(): ImmVec3f = ImmVec3f(xf, yf, zf)
fun Vec3.toImmVec3i(): ImmVec3i = ImmVec3i(xi, yi, zi)
fun Vec3.toImmVec3d(): ImmVec3d = ImmVec3d(xd, yd, zd)

fun Vec3.toMutVec3f(): MutVec3f = MutVec3f(xf, yf, zf)
fun Vec3.toMutVec3i(): MutVec3i = MutVec3i(xi, yi, zi)
fun Vec3.toMutVec3d(): MutVec3d = MutVec3d(xd, yd, zd)

fun Vec3.asImmVec3f(): ImmVec3f = this as? ImmVec3f ?: this.toImmVec3f()
fun Vec3.asImmVec3i(): ImmVec3i = this as? ImmVec3i ?: this.toImmVec3i()
fun Vec3.asImmVec3d(): ImmVec3d = this as? ImmVec3d ?: this.toImmVec3d()

fun Vec3.ceil(): ImmVec3i = ImmVec3i(
    kotlin.math.ceil(xd).toInt(),
    kotlin.math.ceil(yd).toInt(),
    kotlin.math.ceil(zd).toInt()
)

fun Vec3.floor(): ImmVec3i = ImmVec3i(
    kotlin.math.floor(xd).toInt(),
    kotlin.math.floor(yd).toInt(),
    kotlin.math.floor(zd).toInt()
)

fun Vec3.round(): ImmVec3i = ImmVec3i(
    kotlin.math.round(xd).toInt(),
    kotlin.math.round(yd).toInt(),
    kotlin.math.round(zd).toInt()
)

// Utilities

// Vector length a.k.a norm
fun Vec3f.lengthSquare(): Float = xf * xf + yf * yf + zf * zf
fun Vec3f.length(): Float = sqrt(lengthSquare())

fun Vec3d.lengthSquare(): Double = xd * xd + yd * yd + zd * zd
fun Vec3d.length(): Double = sqrt(lengthSquare())

// Distance between 2 points in 3d space
fun Vec3f.distance(other: Vec3): Float = (-this + other).length()
fun Vec3d.distance(other: Vec3): Double = (-this + other).length()

// Apply a transformation to every value
fun Vec3i.transform(func: (Int) -> Int): ImmVec3i = ImmVec3i(func(x), func(y), func(z))
fun Vec3i.transformIndexed(func: (Int, Int) -> Int): ImmVec3i = ImmVec3i(func(x, 0), func(y, 1), func(z, 2))

fun Vec3f.transform(func: (Float) -> Float): ImmVec3f = ImmVec3f(func(x), func(y), func(z))
fun Vec3f.transformIndexed(func: (Float, Int) -> Float): ImmVec3f = ImmVec3f(func(x, 0), func(y, 1), func(z, 2))

fun Vec3d.transform(func: (Double) -> Double): ImmVec3d = ImmVec3d(func(x), func(y), func(z))
fun Vec3d.transformIndexed(func: (Double, Int) -> Double): ImmVec3d = ImmVec3d(func(x, 0), func(y, 1), func(z, 2))

// Dot product of 2 vectors
infix fun Vec3f.dot(other: Vec3): Float = this.xf * other.xf + this.yf * other.yf + this.zf * other.zf
infix fun Vec3d.dot(other: Vec3): Double = this.xd * other.xd + this.yd * other.yd + this.zd * other.zd

// Cross product of 2 vectors
infix fun Vec3f.cross(other: Vec3): ImmVec3f =
    ImmVec3f(yf * other.zf - zf * other.yf, zf * other.xf - xf * other.zf, xf * other.yf - yf * other.xf)

infix fun Vec3d.cross(other: Vec3): ImmVec3d =
    ImmVec3d(yd * other.zd - zd * other.yd, zd * other.xd - xd * other.zd, xd * other.yd - yd * other.xd)


// Reflect/bounce a ray over a plane at origin defined by an unit normal vector
infix fun Vec3f.reflect(normal: Vec3): ImmVec3f {
    val dot2 = this.dot(normal) * 2.0f
    return ImmVec3f(xf - dot2 * normal.xf, yf - dot2 * normal.yf, zf - dot2 * normal.zf)
}

infix fun Vec3d.reflect(normal: Vec3): ImmVec3d {
    val dot2 = this.dot(normal) * 2.0
    return ImmVec3d(xd - dot2 * normal.xd, yd - dot2 * normal.yd, zd - dot2 * normal.zd)
}

// Angle between 2 vectors in radians
infix fun Vec3f.angle(other: Vec3f): Float {
    var cos = (this dot other) / sqrt(this.lengthSquare() * other.lengthSquare())
    // Fixes rounding errors
    cos = if (cos < 1) cos else 1.0f
    cos = if (cos > -1) cos else -1.0f

    // Cos to angle in radians
    return acos(cos)
}

infix fun Vec3d.angle(other: Vec3d): Double {
    var cos = (this dot other) / sqrt(this.lengthSquare() * other.lengthSquare())
    // Fixes rounding errors
    cos = if (cos < 1) cos else 1.0
    cos = if (cos > -1) cos else -1.0

    // Cos to angle in radians
    return acos(cos)
}

// Interpolation between 2 vectors, split must be between [0, 1]
fun Vec3f.lerp(other: Vec3, split: Float): ImmVec3f {
    val inv = 1.0f - split
    return ImmVec3f(
        this.xf * inv + other.xf * split,
        this.yf * inv + other.yf * split,
        this.zf * inv + other.zf * split,
    )
}

fun Vec3d.lerp(other: Vec3, split: Double): ImmVec3d {
    val inv = 1.0 - split
    return ImmVec3d(
        this.xd * inv + other.xd * split,
        this.yd * inv + other.yd * split,
        this.zd * inv + other.zd * split,
    )
}

// Normalized vector
fun Vec3f.normalized(): ImmVec3f {
    val len = length()
    if (len.absoluteValue < 0.0001f) {
        return ImmVec3f()
    }
    if (len == 1.0f) {
        return this.asImmVec3f()
    }
    return ImmVec3f(xf / len, yf / len, zf / len)
}

fun Vec3d.normalized(): ImmVec3d {
    val len = length()
    if (len.absoluteValue < 0.0001) {
        return ImmVec3d()
    }
    if (len == 1.0) {
        return this.asImmVec3d()
    }
    return ImmVec3d(xd / len, yd / len, zd / len)
}

fun MutVec3f.normalize() {
    val len = length()
    if (len.absoluteValue < 0.0001f) {
        return
    }
    if (len == 1.0f) {
        return
    }
    x = xf / len
    y = yf / len
    z = zf / len
}

fun MutVec3d.normalize() {
    val len = length()
    if (len.absoluteValue < 0.0001) {
        return
    }
    if (len == 1.0) {
        return
    }
    x = xd / len
    y = yd / len
    z = zd / len
}