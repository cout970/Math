package com.cout970.math.quaternion

import com.cout970.math.vec3.*
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

// From euler rotations a.k.a rotation angles around the XYZ axis

// Rotate around each axis, Angles in radians
fun ImmQuatfOfEuler(x: Float, y: Float, z: Float): ImmQuatf {
    val sx = sin(x * 0.5f)
    val cx = cos(x * 0.5f)
    val sy = sin(y * 0.5f)
    val cy = cos(y * 0.5f)
    val sz = sin(z * 0.5f)
    val cz = cos(z * 0.5f)

    val cycz = cy * cz
    val sysz = sy * sz
    val sycz = sy * cz
    val cysz = cy * sz

    return ImmQuatf(
        cx * cycz - sx * sysz,
        sx * cycz + cx * sysz,
        cx * sycz - sx * cysz,
        cx * cysz + sx * sycz
    )
}

// Rotate around each axis, Angles in radians
fun MutQuatfOfEuler(x: Float, y: Float, z: Float): MutQuatf {
    val sx = sin(x * 0.5f)
    val cx = cos(x * 0.5f)
    val sy = sin(y * 0.5f)
    val cy = cos(y * 0.5f)
    val sz = sin(z * 0.5f)
    val cz = cos(z * 0.5f)

    val cycz = cy * cz
    val sysz = sy * sz
    val sycz = sy * cz
    val cysz = cy * sz

    return MutQuatf(
        cx * cycz - sx * sysz,
        sx * cycz + cx * sysz,
        cx * sycz - sx * cysz,
        cx * cysz + sx * sycz
    )
}

// Rotate around each axis, Angles in radians
fun ImmQuatdOfEuler(x: Double, y: Double, z: Double): ImmQuatd {
    val sx = sin(x * 0.5)
    val cx = cos(x * 0.5)
    val sy = sin(y * 0.5)
    val cy = cos(y * 0.5)
    val sz = sin(z * 0.5)
    val cz = cos(z * 0.5)

    val cycz = cy * cz
    val sysz = sy * sz
    val sycz = sy * cz
    val cysz = cy * sz

    return ImmQuatd(
        cx * cycz - sx * sysz,
        sx * cycz + cx * sysz,
        cx * sycz - sx * cysz,
        cx * cysz + sx * sycz
    )
}

// Rotate around each axis, Angles in radians
fun MutQuatdOfEuler(x: Double, y: Double, z: Double): MutQuatd {
    val sx = sin(x * 0.5)
    val cx = cos(x * 0.5)
    val sy = sin(y * 0.5)
    val cy = cos(y * 0.5)
    val sz = sin(z * 0.5)
    val cz = cos(z * 0.5)

    val cycz = cy * cz
    val sysz = sy * sz
    val sycz = sy * cz
    val cysz = cy * sz

    return MutQuatd(
        cx * cycz - sx * sysz,
        sx * cycz + cx * sysz,
        cx * sycz - sx * cysz,
        cx * cysz + sx * sycz
    )
}

// From AxisAngle a.k.a Rotation around and axis defined by a vector

// Angle in radians, axis must be normalized
fun ImmQuatfOfAxisAngle(angle: Float, x: Float, y: Float, z: Float): ImmQuatf {
    val sn = sin(angle * 0.5f)
    val cs = cos(angle * 0.5f)
    return ImmQuatf(x * sn, y * sn, z * sn, cs)
}

// Angle in radians, axis must be normalized
fun MutQuatfOfAxisAngle(angle: Float, x: Float, y: Float, z: Float): MutQuatf {
    val sn = sin(angle * 0.5f)
    val cs = cos(angle * 0.5f)
    return MutQuatf(x * sn, y * sn, z * sn, cs)
}

// Angle in radians, axis must be normalized
fun ImmQuatdOfAxisAngle(angle: Double, x: Double, y: Double, z: Double): ImmQuatd {
    val sn = sin(angle * 0.5)
    val cs = cos(angle * 0.5)
    return ImmQuatd(x * sn, y * sn, z * sn, cs)
}

// Angle in radians, axis must be normalized
fun MutQuatdOfAxisAngle(angle: Double, x: Double, y: Double, z: Double): MutQuatd {
    val sn = sin(angle * 0.5)
    val cs = cos(angle * 0.5)
    return MutQuatd(x * sn, y * sn, z * sn, cs)
}

// Rotation around the X axis

// Angle in radians
fun ImmQuatfOfRotX(angle: Float): ImmQuatf {
    val sn = sin(angle * 0.5f)
    val cs = cos(angle * 0.5f)
    return ImmQuatf(sn, 0.0f, 0.0f, cs)
}

// Angle in radians
fun MutQuatfOfRotX(angle: Float): MutQuatf {
    val sn = sin(angle * 0.5f)
    val cs = cos(angle * 0.5f)
    return MutQuatf(sn, 0.0f, 0.0f, cs)
}

// Angle in radians
fun ImmQuatdOfRotX(angle: Double): ImmQuatd {
    val sn = sin(angle * 0.5)
    val cs = cos(angle * 0.5)
    return ImmQuatd(sn, 0.0, 0.0, cs)
}

// Angle in radians
fun MutQuatdOfRotX(angle: Double): MutQuatd {
    val sn = sin(angle * 0.5)
    val cs = cos(angle * 0.5)
    return MutQuatd(sn, 0.0, 0.0, cs)
}

// Rotation around the Y axis

// Angle in radians
fun ImmQuatfOfRotY(angle: Float): ImmQuatf {
    val sn = sin(angle * 0.5f)
    val cs = cos(angle * 0.5f)
    return ImmQuatf(0.0f, sn, 0.0f, cs)
}

// Angle in radians
fun MutQuatfOfRotY(angle: Float): MutQuatf {
    val sn = sin(angle * 0.5f)
    val cs = cos(angle * 0.5f)
    return MutQuatf(0.0f, sn, 0.0f, cs)
}

// Angle in radians
fun ImmQuatdOfRotY(angle: Double): ImmQuatd {
    val sn = sin(angle * 0.5)
    val cs = cos(angle * 0.5)
    return ImmQuatd(0.0, sn, 0.0, cs)
}

// Angle in radians
fun MutQuatdOfRotY(angle: Double): MutQuatd {
    val sn = sin(angle * 0.5)
    val cs = cos(angle * 0.5)
    return MutQuatd(0.0, sn, 0.0, cs)
}

// Rotation around the Z axis

// Angle in radians
fun ImmQuatfOfRotZ(angle: Float): ImmQuatf {
    val sn = sin(angle * 0.5f)
    val cs = cos(angle * 0.5f)
    return ImmQuatf(0.0f, 0.0f, sn, cs)
}

// Angle in radians
fun MutQuatfOfRotZ(angle: Float): MutQuatf {
    val sn = sin(angle * 0.5f)
    val cs = cos(angle * 0.5f)
    return MutQuatf(0.0f, 0.0f, sn, cs)
}

// Angle in radians
fun ImmQuatdOfRotZ(angle: Double): ImmQuatd {
    val sn = sin(angle * 0.5)
    val cs = cos(angle * 0.5)
    return ImmQuatd(0.0, 0.0, sn, cs)
}

// Angle in radians
fun MutQuatdOfRotZ(angle: Double): MutQuatd {
    val sn = sin(angle * 0.5)
    val cs = cos(angle * 0.5)
    return MutQuatd(0.0, 0.0, sn, cs)
}

// From direction to look along

// Create a quaternion that maps the given direction to the positive Z axis.
fun ImmQuatfOfLookAlong(dir: Vec3f, up: Vec3f): ImmQuatf {
    val front = dir.normalized()
    val left = MutVec3f(
        up.y * front.z - up.z * front.y,
        up.z * front.x - up.x * front.z,
        up.x * front.y - up.y * front.x,
    )
    left.normalize()

    val nup = front cross left
    val tr = left.x + nup.y + front.z

    if (tr >= 0.0f) {
        val t0 = sqrt(tr + 1.0f)
        val t1 = 0.5f / t0

        return ImmQuatf(
            x = (front.y - nup.z) * t1,
            y = (left.z - front.x) * t1,
            z = (nup.x - left.y) * t1,
            w = t0 * 0.5f,
        )
    }

    if (left.x > nup.y && left.x > front.z) {
        val t0 = sqrt(left.x - nup.y - front.z + 1.0f)
        val t1 = 0.5f / t0

        return ImmQuatf(
            x = t0 * 0.5f,
            y = (left.y + nup.x) * t1,
            z = (front.x + left.z) * t1,
            w = (front.y - nup.z) * t1,
        )
    }

    if (nup.y > front.z) {
        val t0 = sqrt(nup.y - left.x - front.z + 1.0f)
        val t1 = 0.5f / t0

        return ImmQuatf(
            x = (left.y + nup.x) * t1,
            y = t0 * 0.5f,
            z = (nup.z + front.y) * t1,
            w = (left.z - front.x) * t1,
        )
    }

    val t0 = sqrt(-nup.y - left.x + front.z + 1.0f)
    val t1 = 0.5f / t0

    return ImmQuatf(
        x = (front.x + left.z) * t1,
        y = (nup.z + front.y) * t1,
        z = t0 * 0.5f,
        w = (nup.x - left.y) * t1,
    )
}

// Create a quaternion that maps the given direction to the positive Z axis.
fun MutQuatfOfLookAlong(dir: Vec3f, up: Vec3f): MutQuatf {
    val front = dir.normalized()
    val left = MutVec3f(
        up.y * front.z - up.z * front.y,
        up.z * front.x - up.x * front.z,
        up.x * front.y - up.y * front.x,
    )
    left.normalize()

    val nup = front cross left
    val tr = left.x + nup.y + front.z

    if (tr >= 0.0f) {
        val t0 = sqrt(tr + 1.0f)
        val t1 = 0.5f / t0

        return MutQuatf(
            x = (front.y - nup.z) * t1,
            y = (left.z - front.x) * t1,
            z = (nup.x - left.y) * t1,
            w = t0 * 0.5f,
        )
    }

    if (left.x > nup.y && left.x > front.z) {
        val t0 = sqrt(left.x - nup.y - front.z + 1.0f)
        val t1 = 0.5f / t0

        return MutQuatf(
            x = t0 * 0.5f,
            y = (left.y + nup.x) * t1,
            z = (front.x + left.z) * t1,
            w = (front.y - nup.z) * t1,
        )
    }

    if (nup.y > front.z) {
        val t0 = sqrt(nup.y - left.x - front.z + 1.0f)
        val t1 = 0.5f / t0

        return MutQuatf(
            x = (left.y + nup.x) * t1,
            y = t0 * 0.5f,
            z = (nup.z + front.y) * t1,
            w = (left.z - front.x) * t1,
        )
    }

    val t0 = sqrt(-nup.y - left.x + front.z + 1.0f)
    val t1 = 0.5f / t0

    return MutQuatf(
        x = (front.x + left.z) * t1,
        y = (nup.z + front.y) * t1,
        z = t0 * 0.5f,
        w = (nup.x - left.y) * t1,
    )
}

// Create a quaternion that maps the given direction to the positive Z axis.
fun ImmQuatdOfLookAlong(dir: Vec3d, up: Vec3d): ImmQuatd {
    val front = dir.normalized()
    val left = MutVec3d(
        up.y * front.z - up.z * front.y,
        up.z * front.x - up.x * front.z,
        up.x * front.y - up.y * front.x,
    )
    left.normalize()

    val nup = front cross left
    val tr = left.x + nup.y + front.z

    if (tr >= 0.0) {
        val t0 = sqrt(tr + 1.0)
        val t1 = 0.5 / t0

        return ImmQuatd(
            x = (front.y - nup.z) * t1,
            y = (left.z - front.x) * t1,
            z = (nup.x - left.y) * t1,
            w = t0 * 0.5,
        )
    }

    if (left.x > nup.y && left.x > front.z) {
        val t0 = sqrt(left.x - nup.y - front.z + 1.0)
        val t1 = 0.5 / t0

        return ImmQuatd(
            x = t0 * 0.5,
            y = (left.y + nup.x) * t1,
            z = (front.x + left.z) * t1,
            w = (front.y - nup.z) * t1,
        )
    }

    if (nup.y > front.z) {
        val t0 = sqrt(nup.y - left.x - front.z + 1.0)
        val t1 = 0.5 / t0

        return ImmQuatd(
            x = (left.y + nup.x) * t1,
            y = t0 * 0.5,
            z = (nup.z + front.y) * t1,
            w = (left.z - front.x) * t1,
        )
    }

    val t0 = sqrt(-nup.y - left.x + front.z + 1.0)
    val t1 = 0.5 / t0

    return ImmQuatd(
        x = (front.x + left.z) * t1,
        y = (nup.z + front.y) * t1,
        z = t0 * 0.5,
        w = (nup.x - left.y) * t1,
    )
}

// Create a quaternion that maps the given direction to the positive Z axis.
fun MutQuatdOfLookAlong(dir: Vec3d, up: Vec3d): MutQuatd {
    val front = dir.normalized()
    val left = MutVec3d(
        up.y * front.z - up.z * front.y,
        up.z * front.x - up.x * front.z,
        up.x * front.y - up.y * front.x,
    )
    left.normalize()

    val nup = front cross left
    val tr = left.x + nup.y + front.z

    if (tr >= 0.0) {
        val t0 = sqrt(tr + 1.0)
        val t1 = 0.5 / t0

        return MutQuatd(
            x = (front.y - nup.z) * t1,
            y = (left.z - front.x) * t1,
            z = (nup.x - left.y) * t1,
            w = t0 * 0.5,
        )
    }

    if (left.x > nup.y && left.x > front.z) {
        val t0 = sqrt(left.x - nup.y - front.z + 1.0)
        val t1 = 0.5 / t0

        return MutQuatd(
            x = t0 * 0.5,
            y = (left.y + nup.x) * t1,
            z = (front.x + left.z) * t1,
            w = (front.y - nup.z) * t1,
        )
    }

    if (nup.y > front.z) {
        val t0 = sqrt(nup.y - left.x - front.z + 1.0)
        val t1 = 0.5 / t0

        return MutQuatd(
            x = (left.y + nup.x) * t1,
            y = t0 * 0.5,
            z = (nup.z + front.y) * t1,
            w = (left.z - front.x) * t1,
        )
    }

    val t0 = sqrt(-nup.y - left.x + front.z + 1.0)
    val t1 = 0.5 / t0

    return MutQuatd(
        x = (front.x + left.z) * t1,
        y = (nup.z + front.y) * t1,
        z = t0 * 0.5,
        w = (nup.x - left.y) * t1,
    )
}

// Rotation from one vector to another

// Angle in radians
fun ImmQuatfOfVecAngle(from: Vec3f, to: Vec3f): ImmQuatf {
    val fn = from.normalized()
    val tn = to.normalized()
    val d = fn dot tn

    if (d < -1.0f + 1E-6f) {
        if (fn.y * fn.y + fn.x * fn.x == 0.0f) {
            return ImmQuatf(0.0f, fn.z, -fn.y, 0.0f)
        }

        return ImmQuatf(fn.y, -fn.x, 0.0f, 0.0f)
    }

    val sd2 = sqrt((1.0f + d) * 2.0f)
    val isd2 = 1.0f / sd2
    return ImmQuatf(
        (fn.y * tn.z - fn.z * tn.y) * isd2,
        (fn.z * tn.x - fn.x * tn.z) * isd2,
        (fn.x * tn.y - fn.y * tn.x) * isd2,
        sd2 * 0.5f
    )
}

// Angle in radians
fun MutQuatfOfVecAngle(from: Vec3f, to: Vec3f): MutQuatf {
    val fn = from.normalized()
    val tn = to.normalized()
    val d = fn dot tn

    if (d < -1.0f + 1E-6f) {
        if (fn.y * fn.y + fn.x * fn.x == 0.0f) {
            return MutQuatf(0.0f, fn.z, -fn.y, 0.0f)
        }

        return MutQuatf(fn.y, -fn.x, 0.0f, 0.0f)
    }

    val sd2 = sqrt((1.0f + d) * 2.0f)
    val isd2 = 1.0f / sd2
    return MutQuatf(
        (fn.y * tn.z - fn.z * tn.y) * isd2,
        (fn.z * tn.x - fn.x * tn.z) * isd2,
        (fn.x * tn.y - fn.y * tn.x) * isd2,
        sd2 * 0.5f
    )
}

// Angle in radians
fun ImmQuatdOfVecAngle(from: Vec3d, to: Vec3d): ImmQuatd {
    val fn = from.normalized()
    val tn = to.normalized()
    val d = fn dot tn

    if (d < -1.0 + 1E-6) {
        if (fn.y * fn.y + fn.x * fn.x == 0.0) {
            return ImmQuatd(0.0, fn.z, -fn.y, 0.0)
        }

        return ImmQuatd(fn.y, -fn.x, 0.0, 0.0)
    }

    val sd2 = sqrt((1.0 + d) * 2.0)
    val isd2 = 1.0f / sd2
    return ImmQuatd(
        (fn.y * tn.z - fn.z * tn.y) * isd2,
        (fn.z * tn.x - fn.x * tn.z) * isd2,
        (fn.x * tn.y - fn.y * tn.x) * isd2,
        sd2 * 0.5f
    )
}

// Angle in radians
fun MutQuatdOfVecAngle(from: Vec3d, to: Vec3d): MutQuatd {
    val fn = from.normalized()
    val tn = to.normalized()
    val d = fn dot tn

    if (d < -1.0 + 1E-6) {
        if (fn.y * fn.y + fn.x * fn.x == 0.0) {
            return MutQuatd(0.0, fn.z, -fn.y, 0.0)
        }

        return MutQuatd(fn.y, -fn.x, 0.0, 0.0)
    }

    val sd2 = sqrt((1.0 + d) * 2.0)
    val isd2 = 1.0f / sd2
    return MutQuatd(
        (fn.y * tn.z - fn.z * tn.y) * isd2,
        (fn.z * tn.x - fn.x * tn.z) * isd2,
        (fn.x * tn.y - fn.y * tn.x) * isd2,
        sd2 * 0.5f
    )
}