@file:Suppress("NOTHING_TO_INLINE", "unused")

package com.cout970.math.quaternion

import com.cout970.math.vec3.*
import com.cout970.math.vec4.Vec4
import kotlin.math.*

/**
 * Note: all utilities are implemented as extensions for the following reasons:
 * - Extensions use static dispatch avoiding the cost of virtual methods
 * - Allows to reuse the utilities with new implementations of the base interfaces
 * - Allows to put together functions with the same name and behaviour but with different argument types
 * - Allows to use import alias to rename functions, ej `import math.quat.length as norm`
 */

// unary minus: -a

inline operator fun Quatf.unaryMinus(): ImmQuatf {
    return ImmQuatf(-x, -y, -z, w)
}

inline operator fun Quatd.unaryMinus(): ImmQuatd {
    return ImmQuatd(-x, -y, -z, w)
}

inline fun MutQuatf.invert() {
    x = -x
    y = -y
    z = -z
}

inline fun MutQuatd.invert() {
    x = -x
    y = -y
    z = -z
}

// unary plus: +a

inline operator fun Quatf.unaryPlus(): ImmQuatf {
    return ImmQuatf(+x, +y, +z, +w)
}

inline operator fun Quatd.unaryPlus(): ImmQuatd {
    return ImmQuatd(+x, +y, +z, +w)
}

inline fun MutQuatf.identity() {
    x = 0f
    y = 0f
    z = 0f
    w = 1f
}

inline fun MutQuatd.identity() {
    x = 0.0
    y = 0.0
    z = 0.0
    w = 1.0
}

// times: a * b

operator fun Quatf.times(other: Quat): ImmQuatf {
    return ImmQuatf(
        this.w * other.xf + this.x * other.wf + this.y * other.zf - this.z * other.yf,
        this.w * other.yf - this.x * other.zf + this.y * other.wf + this.z * other.xf,
        this.w * other.zf + this.x * other.yf - this.y * other.xf + this.z * other.wf,
        this.w * other.wf - this.x * other.xf - this.y * other.yf - this.z * other.zf,
    )
}

operator fun Quatd.times(other: Quat): ImmQuatd {
    return ImmQuatd(
        this.w * other.xd + this.x * other.wd + this.y * other.zd - this.z * other.yd,
        this.w * other.yd - this.x * other.zd + this.y * other.wd + this.z * other.xd,
        this.w * other.zd + this.x * other.yd - this.y * other.xd + this.z * other.wd,
        this.w * other.wd - this.x * other.xd - this.y * other.yd - this.z * other.zd,
    )
}

operator fun MutQuatf.timesAssign(other: Quat) {
    val tmpX = this.w * other.xf + this.x * other.wf + this.y * other.zf - this.z * other.yf
    val tmpY = this.w * other.yf - this.x * other.zf + this.y * other.wf + this.z * other.xf
    val tmpZ = this.w * other.zf + this.x * other.yf - this.y * other.xf + this.z * other.wf
    val tmpW = this.w * other.wf - this.x * other.xf - this.y * other.yf - this.z * other.zf

    this.x = tmpX
    this.y = tmpY
    this.z = tmpZ
    this.w = tmpW
}

operator fun MutQuatd.timesAssign(other: Quat) {
    val tmpX = this.w * other.xd + this.x * other.wd + this.y * other.zd - this.z * other.yd
    val tmpY = this.w * other.yd - this.x * other.zd + this.y * other.wd + this.z * other.xd
    val tmpZ = this.w * other.zd + this.x * other.yd - this.y * other.xd + this.z * other.wd
    val tmpW = this.w * other.wd - this.x * other.xd - this.y * other.yd - this.z * other.zd

    this.x = tmpX
    this.y = tmpY
    this.z = tmpZ
    this.w = tmpW
}

// Conversions

fun Quat.toImmQuatf(): ImmQuatf = ImmQuatf(xf, yf, zf, wf)
fun Quat.toImmQuatd(): ImmQuatd = ImmQuatd(xd, yd, zd, wd)

fun Quat.toMutQuatf(): MutQuatf = MutQuatf(xf, yf, zf, wf)
fun Quat.toMutQuatd(): MutQuatd = MutQuatd(xd, yd, zd, wd)

fun Vec4.toImmQuatf(): ImmQuatf = ImmQuatf(xf, yf, zf, wf)
fun Vec4.toImmQuatd(): ImmQuatd = ImmQuatd(xd, yd, zd, wd)

fun Vec4.toMutQuatf(): MutQuatf = MutQuatf(xf, yf, zf, wf)
fun Vec4.toMutQuatd(): MutQuatd = MutQuatd(xd, yd, zd, wd)

fun Quat.asImmQuatf(): ImmQuatf = this as? ImmQuatf ?: this.toImmQuatf()
fun Quat.asImmQuatd(): ImmQuatd = this as? ImmQuatd ?: this.toImmQuatd()

// To Euler rotations

fun Quatf.toEuler(): ImmVec3f {
    val y = 2.0f * (x * z + y * w)
    return ImmVec3f(
        atan2(2.0f * (x * w - y * z), 1.0f - 2.0f * (x * x + y * y)),
        if (y <= -1f) -PI.toFloat() / 2f else if (y >= 1f) PI.toFloat() / 2f else asin(y),
        atan2(2.0f * (z * w - x * y), 1.0f - 2.0f * (y * y + z * z))
    )
}

fun Quatd.toEuler(): ImmVec3d {
    val y = 2.0 * (x * z + y * w)
    return ImmVec3d(
        atan2(2.0 * (x * w - y * z), 1.0 - 2.0 * (x * x + y * y)),
        if (y <= -1.0) -PI / 2.0 else if (y >= 1.0) PI / 2.0 else asin(y),
        atan2(2.0 * (z * w - x * y), 1.0 - 2.0 * (y * y + z * z))
    )
}

// Utilities

// Quaternion length a.k.a norm
// Immutable vectors should already be normalized and have length 1.0
fun Quatf.lengthSquare(): Float = xf * xf + yf * yf + zf * zf + wf * wf
fun Quatf.length(): Float = sqrt(lengthSquare())

fun Quatd.lengthSquare(): Double = xd * xd + yd * yd + zd * zd + wd * wd
fun Quatd.length(): Double = sqrt(lengthSquare())

// Dot product of 2 quaternions
infix fun Quatf.dot(other: Quat): Float =
    this.xf * other.xf + this.yf * other.yf + this.zf * other.zf + this.wf * other.wf

infix fun Quatd.dot(other: Quat): Double =
    this.xd * other.xd + this.yd * other.yd + this.zd * other.zd + this.wd * other.wd

// Interpolation between 2 quaternions, split must be between [0, 1]
fun Quatf.lerp(other: Quat, split: Float): ImmQuatf {
    val inv = 1.0f - split
    val spl = if (this dot other >= 0.0f) split else -split

    return ImmQuatf(
        this.xf * inv + other.xf * spl,
        this.yf * inv + other.yf * spl,
        this.zf * inv + other.zf * spl,
        this.wf * inv + other.wf * spl,
    )
}

fun Quatd.lerp(other: Quat, split: Double): ImmQuatd {
    val inv = 1.0f - split
    val spl = if (this dot other >= 0.0) split else -split

    return ImmQuatd(
        this.xd * inv + other.xd * spl,
        this.yd * inv + other.yd * spl,
        this.zd * inv + other.zd * spl,
        this.wd * inv + other.wd * spl,
    )
}

// Normalized
fun MutQuatf.normalize() {
    val len = length()
    if (len.absoluteValue < 0.0001) {
        return
    }
    x = xf / len
    y = yf / len
    z = zf / len
    w = wf / len
}

fun MutQuatd.normalize() {
    val len = length()
    if (len.absoluteValue < 0.0001) {
        return
    }
    x = xd / len
    y = yd / len
    z = zd / len
    w = wd / len
}

// Rotate vectors

fun Quat.rotate(vec: Vec3f): ImmVec3f {
    val xx: Float = xf * xf
    val yy: Float = yf * yf
    val zz: Float = zf * zf
    val ww: Float = wf * wf
    val xy: Float = xf * yf
    val xz: Float = xf * zf
    val yz: Float = yf * zf
    val xw: Float = xf * wf
    val zw: Float = zf * wf
    val yw: Float = yf * wf
    val v = 1f / (xx + yy + zz + ww)

    return ImmVec3f(
        (xx - yy - zz + ww) * v * vec.xf + 2f * (xy - zw) * v * vec.yf + (2f * (xz + yw) * v) * vec.zf,
        2f * (xy + zw) * v * vec.xf + (yy - xx - zz + ww) * v * vec.yf + (2f * (yz - xw) * v) * vec.zf,
        2f * (xz - yw) * v * vec.xf + 2f * (yz + xw) * v * vec.yf + ((zz - xx - yy + ww) * v) * vec.zf,
    )
}

fun Quat.rotate(vec: Vec3d): ImmVec3d {
    val xx: Double = xd * xd
    val yy: Double = yd * yd
    val zz: Double = zd * zd
    val ww: Double = wd * wd
    val xy: Double = xd * yd
    val xz: Double = xd * zd
    val yz: Double = yd * zd
    val xw: Double = xd * wd
    val zw: Double = zd * wd
    val yw: Double = yd * wd
    val v = 1.0 / (xx + yy + zz + ww)

    return ImmVec3d(
        (xx - yy - zz + ww) * v * vec.xd + 2.0 * (xy - zw) * v * vec.yd + (2.0 * (xz + yw) * v) * vec.zd,
        2.0 * (xy + zw) * v * vec.xd + (yy - xx - zz + ww) * v * vec.yd + (2.0 * (yz - xw) * v) * vec.zd,
        2.0 * (xz - yw) * v * vec.xd + 2.0 * (yz + xw) * v * vec.yd + ((zz - xx - yy + ww) * v) * vec.zd,
    )
}

fun Quat.rotateMut(vec: MutVec3f) {
    val xx: Float = xf * xf
    val yy: Float = yf * yf
    val zz: Float = zf * zf
    val ww: Float = wf * wf
    val xy: Float = xf * yf
    val xz: Float = xf * zf
    val yz: Float = yf * zf
    val xw: Float = xf * wf
    val zw: Float = zf * wf
    val yw: Float = yf * wf
    val v = 1f / (xx + yy + zz + ww)

    val tempX = (xx - yy - zz + ww) * v * vec.xf + 2f * (xy - zw) * v * vec.yf + (2f * (xz + yw) * v) * vec.zf
    val tempY = 2f * (xy + zw) * v * vec.xf + (yy - xx - zz + ww) * v * vec.yf + (2f * (yz - xw) * v) * vec.zf
    val tempZ = 2f * (xz - yw) * v * vec.xf + 2f * (yz + xw) * v * vec.yf + ((zz - xx - yy + ww) * v) * vec.zf

    vec.x = tempX
    vec.y = tempY
    vec.z = tempZ
}

fun Quat.rotateMut(vec: MutVec3d) {
    val xx: Double = xd * xd
    val yy: Double = yd * yd
    val zz: Double = zd * zd
    val ww: Double = wd * wd
    val xy: Double = xd * yd
    val xz: Double = xd * zd
    val yz: Double = yd * zd
    val xw: Double = xd * wd
    val zw: Double = zd * wd
    val yw: Double = yd * wd
    val v = 1.0 / (xx + yy + zz + ww)

    val tempX = (xx - yy - zz + ww) * v * vec.xd + 2.0 * (xy - zw) * v * vec.yd + (2.0 * (xz + yw) * v) * vec.zd
    val tempY = 2.0 * (xy + zw) * v * vec.xd + (yy - xx - zz + ww) * v * vec.yd + (2.0 * (yz - xw) * v) * vec.zd
    val tempZ = 2.0 * (xz - yw) * v * vec.xd + 2.0 * (yz + xw) * v * vec.yd + ((zz - xx - yy + ww) * v) * vec.zd

    vec.x = tempX
    vec.y = tempY
    vec.z = tempZ
}