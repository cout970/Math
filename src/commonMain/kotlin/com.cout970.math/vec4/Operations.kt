@file:Suppress("NOTHING_TO_INLINE", "unused")

package com.cout970.math.vec4

import com.cout970.math.quaternion.Quat
import kotlin.math.absoluteValue
import kotlin.math.acos
import kotlin.math.sqrt

/**
 * Note: all utilities are implemented as extensions for the following reasons:
 * - Extensions use static dispatch avoiding the cost of virtual methods
 * - Allows to reuse the utilities with new implementations of the base interfaces
 * - Allows to put together functions with the same name and behaviour but with different argument types
 * - Allows to use import alias to rename functions, ej `import math.vec4.length as norm`
 */

// plus: a + b

operator fun Vec4f.plus(other: Vec4): ImmVec4f {
    return ImmVec4f(this.x + other.xf, this.y + other.yf, this.z + other.zf, this.w + other.wf)
}

operator fun Vec4i.plus(other: Vec4): ImmVec4i {
    return ImmVec4i(this.x + other.xi, this.y + other.yi, this.z + other.zi, this.w + other.wi)
}

operator fun Vec4d.plus(other: Vec4): ImmVec4d {
    return ImmVec4d(this.x + other.xd, this.y + other.yd, this.z + other.zd, this.w + other.wd)
}

inline operator fun Vec4f.plus(other: Number): ImmVec4f {
    return ImmVec4f(
        this.x + other.toFloat(),
        this.y + other.toFloat(),
        this.z + other.toFloat(),
        this.w + other.toFloat()
    )
}

inline operator fun Vec4i.plus(other: Number): ImmVec4i {
    return ImmVec4i(this.x + other.toInt(), this.y + other.toInt(), this.z + other.toInt(), this.w + other.toInt())
}

inline operator fun Vec4d.plus(other: Number): ImmVec4d {
    return ImmVec4d(
        this.x + other.toDouble(),
        this.y + other.toDouble(),
        this.z + other.toDouble(),
        this.w + other.toDouble()
    )
}

operator fun MutVec4f.plusAssign(other: Vec4) {
    this.x = this.x + other.xf
    this.y = this.y + other.yf
    this.z = this.z + other.zf
    this.w = this.w + other.wf
}

operator fun MutVec4i.plusAssign(other: Vec4) {
    this.x = this.x + other.xi
    this.y = this.y + other.yi
    this.z = this.z + other.zi
    this.w = this.w + other.wi
}

operator fun MutVec4d.plusAssign(other: Vec4) {
    this.x = this.x + other.xd
    this.y = this.y + other.yd
    this.z = this.z + other.zd
    this.w = this.w + other.wd
}

// minus: a - b

operator fun Vec4f.minus(other: Vec4): ImmVec4f {
    return ImmVec4f(this.x - other.xf, this.y - other.yf, this.z - other.zf, this.w - other.wf)
}

operator fun Vec4i.minus(other: Vec4): ImmVec4i {
    return ImmVec4i(this.x - other.xi, this.y - other.yi, this.z - other.zi, this.w - other.wi)
}

operator fun Vec4d.minus(other: Vec4): ImmVec4d {
    return ImmVec4d(this.x - other.xd, this.y - other.yd, this.z - other.zd, this.w - other.wd)
}

inline operator fun Vec4f.minus(other: Number): ImmVec4f {
    return ImmVec4f(
        this.x - other.toFloat(),
        this.y - other.toFloat(),
        this.z - other.toFloat(),
        this.w - other.toFloat()
    )
}

inline operator fun Vec4i.minus(other: Number): ImmVec4i {
    return ImmVec4i(this.x - other.toInt(), this.y - other.toInt(), this.z - other.toInt(), this.w - other.toInt())
}

inline operator fun Vec4d.minus(other: Number): ImmVec4d {
    return ImmVec4d(
        this.x - other.toDouble(),
        this.y - other.toDouble(),
        this.z - other.toDouble(),
        this.w - other.toDouble()
    )
}

operator fun MutVec4f.minusAssign(other: Vec4) {
    this.x = this.x - other.xf
    this.y = this.y - other.yf
    this.z = this.z - other.zf
    this.w = this.w - other.wf
}

operator fun MutVec4i.minusAssign(other: Vec4) {
    this.x = this.x - other.xi
    this.y = this.y - other.yi
    this.z = this.z - other.zi
    this.w = this.w - other.wi
}

operator fun MutVec4d.minusAssign(other: Vec4) {
    this.x = this.x - other.xd
    this.y = this.y - other.yd
    this.z = this.z - other.zd
    this.w = this.w - other.wd
}

// unary minus: -a

inline operator fun Vec4f.unaryMinus(): ImmVec4f {
    return ImmVec4f(-x, -y, -z, -w)
}

inline operator fun Vec4i.unaryMinus(): ImmVec4i {
    return ImmVec4i(-x, -y, -z, -w)
}

inline operator fun Vec4d.unaryMinus(): ImmVec4d {
    return ImmVec4d(-x, -y, -z, -w)
}

// unary plus: +a

inline operator fun Vec4f.unaryPlus(): ImmVec4f {
    return ImmVec4f(+x, +y, +z, +w)
}

inline operator fun Vec4i.unaryPlus(): ImmVec4i {
    return ImmVec4i(+x, +y, +z, +w)
}

inline operator fun Vec4d.unaryPlus(): ImmVec4d {
    return ImmVec4d(+x, +y, +z, +w)
}

// times: a * b

operator fun Vec4f.times(other: Vec4): ImmVec4f {
    return ImmVec4f(this.x * other.xf, this.y * other.yf, this.z * other.zf, this.w * other.wf)
}

operator fun Vec4i.times(other: Vec4): ImmVec4i {
    return ImmVec4i(this.x * other.xi, this.y * other.yi, this.z * other.zi, this.w * other.wi)
}

operator fun Vec4d.times(other: Vec4): ImmVec4d {
    return ImmVec4d(this.x * other.xd, this.y * other.yd, this.z * other.zd, this.w * other.wd)
}

inline operator fun Vec4f.times(other: Number): ImmVec4f {
    return ImmVec4f(
        this.x * other.toFloat(),
        this.y * other.toFloat(),
        this.z * other.toFloat(),
        this.w * other.toFloat()
    )
}

inline operator fun Vec4i.times(other: Number): ImmVec4i {
    return ImmVec4i(this.x * other.toInt(), this.y * other.toInt(), this.z * other.toInt(), this.w * other.toInt())
}

inline operator fun Vec4d.times(other: Number): ImmVec4d {
    return ImmVec4d(
        this.x * other.toDouble(),
        this.y * other.toDouble(),
        this.z * other.toDouble(),
        this.w * other.toDouble()
    )
}

operator fun MutVec4f.timesAssign(other: Vec4) {
    this.x = this.x * other.xf
    this.y = this.y * other.yf
    this.z = this.z * other.zf
    this.w = this.w * other.wf
}

operator fun MutVec4i.timesAssign(other: Vec4) {
    this.x = this.x * other.xi
    this.y = this.y * other.yi
    this.z = this.z * other.zi
    this.w = this.w * other.wi
}

operator fun MutVec4d.timesAssign(other: Vec4) {
    this.x = this.x * other.xd
    this.y = this.y * other.yd
    this.z = this.z * other.zd
    this.w = this.w * other.wd
}

// div: a / b

operator fun Vec4f.div(other: Vec4): ImmVec4f {
    return ImmVec4f(this.x / other.xf, this.y / other.yf, this.z / other.zf, this.w / other.wf)
}

operator fun Vec4i.div(other: Vec4): ImmVec4i {
    return ImmVec4i(this.x / other.xi, this.y / other.yi, this.z / other.zi, this.w / other.wi)
}

operator fun Vec4d.div(other: Vec4): ImmVec4d {
    return ImmVec4d(this.x / other.xd, this.y / other.yd, this.z / other.zd, this.w / other.wd)
}

inline operator fun Vec4f.div(other: Number): ImmVec4f {
    return ImmVec4f(
        this.x / other.toFloat(),
        this.y / other.toFloat(),
        this.z / other.toFloat(),
        this.w / other.toFloat()
    )
}

inline operator fun Vec4i.div(other: Number): ImmVec4i {
    return ImmVec4i(this.x / other.toInt(), this.y / other.toInt(), this.z / other.toInt(), this.w / other.toInt())
}

inline operator fun Vec4d.div(other: Number): ImmVec4d {
    return ImmVec4d(
        this.x / other.toDouble(),
        this.y / other.toDouble(),
        this.z / other.toDouble(),
        this.w / other.toDouble()
    )
}

operator fun MutVec4f.divAssign(other: Vec4) {
    this.x = this.x / other.xf
    this.y = this.y / other.yf
    this.z = this.z / other.zf
    this.w = this.w / other.wf
}

operator fun MutVec4i.divAssign(other: Vec4) {
    this.x = this.x / other.xi
    this.y = this.y / other.yi
    this.z = this.z / other.zi
    this.w = this.w / other.wi
}

operator fun MutVec4d.divAssign(other: Vec4) {
    this.x = this.x / other.xd
    this.y = this.y / other.yd
    this.z = this.z / other.zd
    this.w = this.w / other.wd
}

// rem: a % b

operator fun Vec4f.rem(other: Vec4): ImmVec4f {
    return ImmVec4f(this.x % other.xf, this.y % other.yf, this.z % other.zf, this.w % other.wf)
}

operator fun Vec4i.rem(other: Vec4): ImmVec4i {
    return ImmVec4i(this.x % other.xi, this.y % other.yi, this.z % other.zi, this.w % other.wi)
}

operator fun Vec4d.rem(other: Vec4): ImmVec4d {
    return ImmVec4d(this.x % other.xd, this.y % other.yd, this.z % other.zd, this.w % other.wd)
}

inline operator fun Vec4f.rem(other: Number): ImmVec4f {
    return ImmVec4f(
        this.x % other.toFloat(),
        this.y % other.toFloat(),
        this.z % other.toFloat(),
        this.w % other.toFloat()
    )
}

inline operator fun Vec4i.rem(other: Number): ImmVec4i {
    return ImmVec4i(this.x % other.toInt(), this.y % other.toInt(), this.z % other.toInt(), this.w % other.toInt())
}

inline operator fun Vec4d.rem(other: Number): ImmVec4d {
    return ImmVec4d(
        this.x % other.toDouble(),
        this.y % other.toDouble(),
        this.z % other.toDouble(),
        this.w % other.toDouble()
    )
}

operator fun MutVec4f.remAssign(other: Vec4) {
    this.x = this.x % other.xf
    this.y = this.y % other.yf
    this.z = this.z % other.zf
    this.w = this.w % other.wf
}

operator fun MutVec4i.remAssign(other: Vec4) {
    this.x = this.x % other.xi
    this.y = this.y % other.yi
    this.z = this.z % other.zi
    this.w = this.w % other.wi
}

operator fun MutVec4d.remAssign(other: Vec4) {
    this.x = this.x % other.xd
    this.y = this.y % other.yd
    this.z = this.z % other.zd
    this.w = this.w % other.wd
}

// Conversions

fun Vec4.toImmVec4f(): ImmVec4f = ImmVec4f(xf, yf, zf, wf)
fun Vec4.toImmVec4i(): ImmVec4i = ImmVec4i(xi, yi, zi, wi)
fun Vec4.toImmVec4d(): ImmVec4d = ImmVec4d(xd, yd, zd, wd)

fun Vec4.toMutVec4f(): MutVec4f = MutVec4f(xf, yf, zf, wf)
fun Vec4.toMutVec4i(): MutVec4i = MutVec4i(xi, yi, zi, wi)
fun Vec4.toMutVec4d(): MutVec4d = MutVec4d(xd, yd, zd, wd)

fun Quat.toImmVec4f(): ImmVec4f = ImmVec4f(xf, yf, zf, wf)
fun Quat.toImmVec4d(): ImmVec4d = ImmVec4d(xd, yd, zd, wd)

fun Quat.toMutVec4f(): MutVec4f = MutVec4f(xf, yf, zf, wf)
fun Quat.toMutVec4d(): MutVec4d = MutVec4d(xd, yd, zd, wd)

fun Vec4.asImmVec4f(): ImmVec4f = this as? ImmVec4f ?: this.toImmVec4f()
fun Vec4.asImmVec4i(): ImmVec4i = this as? ImmVec4i ?: this.toImmVec4i()
fun Vec4.asImmVec4d(): ImmVec4d = this as? ImmVec4d ?: this.toImmVec4d()

fun Vec4.ceil(): ImmVec4i = ImmVec4i(
    kotlin.math.ceil(xd).toInt(),
    kotlin.math.ceil(yd).toInt(),
    kotlin.math.ceil(zd).toInt(),
    kotlin.math.ceil(wd).toInt()
)

fun Vec4.floor(): ImmVec4i = ImmVec4i(
    kotlin.math.floor(xd).toInt(),
    kotlin.math.floor(yd).toInt(),
    kotlin.math.floor(zd).toInt(),
    kotlin.math.floor(wd).toInt()
)

fun Vec4.round(): ImmVec4i = ImmVec4i(
    kotlin.math.round(xd).toInt(),
    kotlin.math.round(yd).toInt(),
    kotlin.math.round(zd).toInt(),
    kotlin.math.round(wd).toInt()
)

// Utilities

// Vector length a.k.a norm
fun Vec4f.lengthSquare(): Float = xf * xf + yf * yf + zf * zf + wf * wf
fun Vec4f.length(): Float = sqrt(lengthSquare())

fun Vec4d.lengthSquare(): Double = xd * xd + yd * yd + zd * zd + wd * wd
fun Vec4d.length(): Double = sqrt(lengthSquare())

// Distance between 2 points in 3d space
fun Vec4f.distance(other: Vec4): Float = (-this + other).length()
fun Vec4d.distance(other: Vec4): Double = (-this + other).length()

// Apply a transformation to every value
fun Vec4i.transform(func: (Int) -> Int): ImmVec4i = ImmVec4i(func(x), func(y), func(z), func(w))
fun Vec4i.transformIndexed(func: (Int, Int) -> Int): ImmVec4i = ImmVec4i(func(x, 0), func(y, 1), func(z, 2), func(w, 3))

fun Vec4f.transform(func: (Float) -> Float): ImmVec4f = ImmVec4f(func(x), func(y), func(z), func(w))
fun Vec4f.transformIndexed(func: (Float, Int) -> Float): ImmVec4f =
    ImmVec4f(func(x, 0), func(y, 1), func(z, 2), func(w, 3))

fun Vec4d.transform(func: (Double) -> Double): ImmVec4d = ImmVec4d(func(x), func(y), func(z), func(w))
fun Vec4d.transformIndexed(func: (Double, Int) -> Double): ImmVec4d =
    ImmVec4d(func(x, 0), func(y, 1), func(z, 2), func(w, 3))

// Dot product of 2 vectors
infix fun Vec4f.dot(other: Vec4): Float =
    this.xf * other.xf + this.yf * other.yf + this.zf * other.zf + this.wf * other.wf

infix fun Vec4d.dot(other: Vec4): Double =
    this.xd * other.xd + this.yd * other.yd + this.zd * other.zd + this.wd * other.wd


// Reflect/bounce a ray over a plane at origin defined by an unit normal vector
infix fun Vec4f.reflect(normal: Vec4): ImmVec4f {
    val dot2 = this.dot(normal) * 2.0f
    return ImmVec4f(xf - dot2 * normal.xf, yf - dot2 * normal.yf, zf - dot2 * normal.zf, wf - dot2 * normal.wf)
}

infix fun Vec4d.reflect(normal: Vec4): ImmVec4d {
    val dot2 = this.dot(normal) * 2.0
    return ImmVec4d(xd - dot2 * normal.xd, yd - dot2 * normal.yd, zd - dot2 * normal.zd, wd - dot2 * normal.wd)
}

// Angle between 2 vectors in radians
infix fun Vec4f.angle(other: Vec4f): Float {
    var cos = (this dot other) / sqrt(this.lengthSquare() * other.lengthSquare())
    // Fixes rounding errors
    cos = if (cos < 1) cos else 1.0f
    cos = if (cos > -1) cos else -1.0f

    // Cos to angle in radians
    return acos(cos)
}

infix fun Vec4d.angle(other: Vec4d): Double {
    var cos = (this dot other) / sqrt(this.lengthSquare() * other.lengthSquare())
    // Fixes rounding errors
    cos = if (cos < 1) cos else 1.0
    cos = if (cos > -1) cos else -1.0

    // Cos to angle in radians
    return acos(cos)
}

// Interpolation between 2 vectors, split must be between [0, 1]
fun Vec4f.lerp(other: Vec4, split: Float): ImmVec4f {
    val inv = 1.0f - split
    return ImmVec4f(
        this.xf * inv + other.xf * split,
        this.yf * inv + other.yf * split,
        this.zf * inv + other.zf * split,
        this.wf * inv + other.wf * split,
    )
}

fun Vec4d.lerp(other: Vec4, split: Double): ImmVec4d {
    val inv = 1.0 - split
    return ImmVec4d(
        this.xd * inv + other.xd * split,
        this.yd * inv + other.yd * split,
        this.zd * inv + other.zd * split,
        this.wd * inv + other.wd * split,
    )
}

// Normalized vector
fun Vec4f.normalized(): ImmVec4f {
    val len = length()
    if (len.absoluteValue < 0.0001) {
        return ImmVec4f()
    }
    if (len == 1.0f) {
        return this.toImmVec4f()
    }
    return ImmVec4f(xf / len, yf / len, zf / len, wf / len)
}

fun Vec4d.normalized(): ImmVec4d {
    val len = length()
    if (len.absoluteValue < 0.0001) {
        return ImmVec4d()
    }
    if (len == 1.0) {
        return this.toImmVec4d()
    }
    return ImmVec4d(xd / len, yd / len, zd / len, wd / len)
}

fun MutVec4f.normalize() {
    val len = length()
    if (len.absoluteValue < 0.0001) {
        return
    }
    if (len == 1.0f) {
        return
    }
    x = xf / len
    y = yf / len
    z = zf / len
    w = wf / len
}

fun MutVec4d.normalize() {
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
    w = wd / len
}