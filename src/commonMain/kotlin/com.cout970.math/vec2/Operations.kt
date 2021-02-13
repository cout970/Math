@file:Suppress("NOTHING_TO_INLINE", "unused")

package com.cout970.math.vec2

import com.cout970.math.vec2.*
import kotlin.math.absoluteValue
import kotlin.math.acos
import kotlin.math.sqrt

/**
 * Note: all utilities are implemented as extensions for the following reasons:
 * - Extensions use static dispatch avoiding the cost of virtual methods
 * - Allows to reuse the utilities with new implementations of the base interfaces
 * - Allows to put together functions with the same name and behaviour but with different argument types
 * - Allows to use import alias to rename functions, ej `import math.vec2.length as norm`
 */

// plus: a + b

operator fun Vec2f.plus(other: Vec2): ImmVec2f {
    return ImmVec2f(this.x + other.xf, this.y + other.yf)
}

operator fun Vec2i.plus(other: Vec2): ImmVec2i {
    return ImmVec2i(this.x + other.xi, this.y + other.yi)
}

operator fun Vec2d.plus(other: Vec2): ImmVec2d {
    return ImmVec2d(this.x + other.xd, this.y + other.yd)
}

inline operator fun Vec2f.plus(other: Number): ImmVec2f {
    return ImmVec2f(this.x + other.toFloat(), this.y + other.toFloat())
}

inline operator fun Vec2i.plus(other: Number): ImmVec2i {
    return ImmVec2i(this.x + other.toInt(), this.y + other.toInt())
}

inline operator fun Vec2d.plus(other: Number): ImmVec2d {
    return ImmVec2d(this.x + other.toDouble(), this.y + other.toDouble())
}

operator fun MutVec2f.plusAssign(other: Vec2) {
    this.x = this.x + other.xf
    this.y = this.y + other.yf
}

operator fun MutVec2i.plusAssign(other: Vec2) {
    this.x = this.x + other.xi
    this.y = this.y + other.yi
}

operator fun MutVec2d.plusAssign(other: Vec2) {
    this.x = this.x + other.xd
    this.y = this.y + other.yd
}

// minus: a - b

operator fun Vec2f.minus(other: Vec2): ImmVec2f {
    return ImmVec2f(this.x - other.xf, this.y - other.yf)
}

operator fun Vec2i.minus(other: Vec2): ImmVec2i {
    return ImmVec2i(this.x - other.xi, this.y - other.yi)
}

operator fun Vec2d.minus(other: Vec2): ImmVec2d {
    return ImmVec2d(this.x - other.xd, this.y - other.yd)
}

inline operator fun Vec2f.minus(other: Number): ImmVec2f {
    return ImmVec2f(this.x - other.toFloat(), this.y - other.toFloat())
}

inline operator fun Vec2i.minus(other: Number): ImmVec2i {
    return ImmVec2i(this.x - other.toInt(), this.y - other.toInt())
}

inline operator fun Vec2d.minus(other: Number): ImmVec2d {
    return ImmVec2d(this.x - other.toDouble(), this.y - other.toDouble())
}

operator fun MutVec2f.minusAssign(other: Vec2) {
    this.x = this.x - other.xf
    this.y = this.y - other.yf
}

operator fun MutVec2i.minusAssign(other: Vec2) {
    this.x = this.x - other.xi
    this.y = this.y - other.yi
}

operator fun MutVec2d.minusAssign(other: Vec2) {
    this.x = this.x - other.xd
    this.y = this.y - other.yd
}

// unary minus: -a

inline operator fun Vec2f.unaryMinus(): ImmVec2f {
    return ImmVec2f(-x, -y)
}

inline operator fun Vec2i.unaryMinus(): ImmVec2i {
    return ImmVec2i(-x, -y)
}

inline operator fun Vec2d.unaryMinus(): ImmVec2d {
    return ImmVec2d(-x, -y)
}

// unary plus: +a

inline operator fun Vec2f.unaryPlus(): ImmVec2f {
    return ImmVec2f(+x, +y)
}

inline operator fun Vec2i.unaryPlus(): ImmVec2i {
    return ImmVec2i(+x, +y)
}

inline operator fun Vec2d.unaryPlus(): ImmVec2d {
    return ImmVec2d(+x, +y)
}

// times: a * b

operator fun Vec2f.times(other: Vec2): ImmVec2f {
    return ImmVec2f(this.x * other.xf, this.y * other.yf)
}

operator fun Vec2i.times(other: Vec2): ImmVec2i {
    return ImmVec2i(this.x * other.xi, this.y * other.yi)
}

operator fun Vec2d.times(other: Vec2): ImmVec2d {
    return ImmVec2d(this.x * other.xd, this.y * other.yd)
}

inline operator fun Vec2f.times(other: Number): ImmVec2f {
    return ImmVec2f(this.x * other.toFloat(), this.y * other.toFloat())
}

inline operator fun Vec2i.times(other: Number): ImmVec2i {
    return ImmVec2i(this.x * other.toInt(), this.y * other.toInt())
}

inline operator fun Vec2d.times(other: Number): ImmVec2d {
    return ImmVec2d(this.x * other.toDouble(), this.y * other.toDouble())
}

operator fun MutVec2f.timesAssign(other: Vec2) {
    this.x = this.x * other.xf
    this.y = this.y * other.yf
}

operator fun MutVec2i.timesAssign(other: Vec2) {
    this.x = this.x * other.xi
    this.y = this.y * other.yi
}

operator fun MutVec2d.timesAssign(other: Vec2) {
    this.x = this.x * other.xd
    this.y = this.y * other.yd
}

// div: a / b

operator fun Vec2f.div(other: Vec2): ImmVec2f {
    return ImmVec2f(this.x / other.xf, this.y / other.yf)
}

operator fun Vec2i.div(other: Vec2): ImmVec2i {
    return ImmVec2i(this.x / other.xi, this.y / other.yi)
}

operator fun Vec2d.div(other: Vec2): ImmVec2d {
    return ImmVec2d(this.x / other.xd, this.y / other.yd)
}

inline operator fun Vec2f.div(other: Number): ImmVec2f {
    return ImmVec2f(this.x / other.toFloat(), this.y / other.toFloat())
}

inline operator fun Vec2i.div(other: Number): ImmVec2i {
    return ImmVec2i(this.x / other.toInt(), this.y / other.toInt())
}

inline operator fun Vec2d.div(other: Number): ImmVec2d {
    return ImmVec2d(this.x / other.toDouble(), this.y / other.toDouble())
}

operator fun MutVec2f.divAssign(other: Vec2) {
    this.x = this.x / other.xf
    this.y = this.y / other.yf
}

operator fun MutVec2i.divAssign(other: Vec2) {
    this.x = this.x / other.xi
    this.y = this.y / other.yi
}

operator fun MutVec2d.divAssign(other: Vec2) {
    this.x = this.x / other.xd
    this.y = this.y / other.yd
}

// rem: a % b

operator fun Vec2f.rem(other: Vec2): ImmVec2f {
    return ImmVec2f(this.x % other.xf, this.y % other.yf)
}

operator fun Vec2i.rem(other: Vec2): ImmVec2i {
    return ImmVec2i(this.x % other.xi, this.y % other.yi)
}

operator fun Vec2d.rem(other: Vec2): ImmVec2d {
    return ImmVec2d(this.x % other.xd, this.y % other.yd)
}

inline operator fun Vec2f.rem(other: Number): ImmVec2f {
    return ImmVec2f(this.x % other.toFloat(), this.y % other.toFloat())
}

inline operator fun Vec2i.rem(other: Number): ImmVec2i {
    return ImmVec2i(this.x % other.toInt(), this.y % other.toInt())
}

inline operator fun Vec2d.rem(other: Number): ImmVec2d {
    return ImmVec2d(this.x % other.toDouble(), this.y % other.toDouble())
}

operator fun MutVec2f.remAssign(other: Vec2) {
    this.x = this.x % other.xf
    this.y = this.y % other.yf
}

operator fun MutVec2i.remAssign(other: Vec2) {
    this.x = this.x % other.xi
    this.y = this.y % other.yi
}

operator fun MutVec2d.remAssign(other: Vec2) {
    this.x = this.x % other.xd
    this.y = this.y % other.yd
}

// Conversions

fun Vec2.toImmVec2f(): ImmVec2f = ImmVec2f(xf, yf)
fun Vec2.toImmVec2i(): ImmVec2i = ImmVec2i(xi, yi)
fun Vec2.toImmVec2d(): ImmVec2d = ImmVec2d(xd, yd)

fun Vec2.toMutVec2f(): MutVec2f = MutVec2f(xf, yf)
fun Vec2.toMutVec2i(): MutVec2i = MutVec2i(xi, yi)
fun Vec2.toMutVec2d(): MutVec2d = MutVec2d(xd, yd)

fun Vec2.asImmVec2f(): ImmVec2f = this as? ImmVec2f ?: this.toImmVec2f()
fun Vec2.asImmVec2i(): ImmVec2i = this as? ImmVec2i ?: this.toImmVec2i()
fun Vec2.asImmVec2d(): ImmVec2d = this as? ImmVec2d ?: this.toImmVec2d()

fun Vec2.ceil(): ImmVec2i = ImmVec2i(
    kotlin.math.ceil(xd).toInt(),
    kotlin.math.ceil(yd).toInt(),
)

fun Vec2.floor(): ImmVec2i = ImmVec2i(
    kotlin.math.floor(xd).toInt(),
    kotlin.math.floor(yd).toInt(),
)

fun Vec2.round(): ImmVec2i = ImmVec2i(
    kotlin.math.round(xd).toInt(),
    kotlin.math.round(yd).toInt(),
)

// Utilities

// Vector length a.k.a norm
fun Vec2f.lengthSquare(): Float = xf * xf + yf * yf
fun Vec2f.length(): Float = sqrt(lengthSquare())

fun Vec2d.lengthSquare(): Double = xd * xd + yd * yd
fun Vec2d.length(): Double = sqrt(lengthSquare())

// Distance between 2 points
fun Vec2f.distance(other: Vec2): Float = (-this + other).length()
fun Vec2d.distance(other: Vec2): Double = (-this + other).length()

// Apply a transformation to every value
fun Vec2i.transform(func: (Int) -> Int): ImmVec2i = ImmVec2i(func(x), func(y))
fun Vec2i.transformIndexed(func: (Int, Int) -> Int): ImmVec2i = ImmVec2i(func(x, 0), func(y, 1))

fun Vec2f.transform(func: (Float) -> Float): ImmVec2f = ImmVec2f(func(x), func(y))
fun Vec2f.transformIndexed(func: (Float, Int) -> Float): ImmVec2f = ImmVec2f(func(x, 0), func(y, 1))

fun Vec2d.transform(func: (Double) -> Double): ImmVec2d = ImmVec2d(func(x), func(y))
fun Vec2d.transformIndexed(func: (Double, Int) -> Double): ImmVec2d = ImmVec2d(func(x, 0), func(y, 1))

// Dot product of 2 vectors
infix fun Vec2f.dot(other: Vec2): Float = this.xf * other.xf + this.yf * other.yf
infix fun Vec2d.dot(other: Vec2): Double = this.xd * other.xd + this.yd * other.yd


// Reflect/bounce a ray over a plane at origin defined by an unit normal vector
infix fun Vec2f.reflect(normal: Vec2): ImmVec2f {
    val dot2 = this.dot(normal) * 2.0f
    return ImmVec2f(xf - dot2 * normal.xf, yf - dot2 * normal.yf)
}

infix fun Vec2d.reflect(normal: Vec2): ImmVec2d {
    val dot2 = this.dot(normal) * 2.0
    return ImmVec2d(xd - dot2 * normal.xd, yd - dot2 * normal.yd)
}

// Angle between 2 vectors in radians
infix fun Vec2f.angle(other: Vec2f): Float {
    var cos = (this dot other) / sqrt(this.lengthSquare() * other.lengthSquare())
    // Fixes rounding errors
    cos = if (cos < 1) cos else 1.0f
    cos = if (cos > -1) cos else -1.0f

    // Cos to angle in radians
    return acos(cos)
}

infix fun Vec2d.angle(other: Vec2d): Double {
    var cos = (this dot other) / sqrt(this.lengthSquare() * other.lengthSquare())
    // Fixes rounding errors
    cos = if (cos < 1) cos else 1.0
    cos = if (cos > -1) cos else -1.0

    // Cos to angle in radians
    return acos(cos)
}

// Interpolation between 2 vectors, split must be between [0, 1]
fun Vec2f.lerp(other: Vec2, split: Float): ImmVec2f {
    val inv = 1.0f - split
    return ImmVec2f(
        this.xf * inv + other.xf * split,
        this.yf * inv + other.yf * split,
    )
}

fun Vec2d.lerp(other: Vec2, split: Double): ImmVec2d {
    val inv = 1.0 - split
    return ImmVec2d(
        this.xd * inv + other.xd * split,
        this.yd * inv + other.yd * split,
    )
}

// Normalized vector
fun Vec2f.normalized(): ImmVec2f {
    val len = length()
    if (len.absoluteValue < 0.0001) {
        return ImmVec2f()
    }
    return ImmVec2f(xf / len, yf / len)
}

fun Vec2d.normalized(): ImmVec2d {
    val len = length()
    if (len.absoluteValue < 0.0001) {
        return ImmVec2d()
    }
    return ImmVec2d(xd / len, yd / len)
}

fun MutVec2f.normalize() {
    val len = length()
    if (len.absoluteValue < 0.0001) {
        return
    }
    x = xf / len
    y = yf / len
}

fun MutVec2d.normalize() {
    val len = length()
    if (len.absoluteValue < 0.0001) {
        return
    }
    x = xd / len
    y = yd / len
}