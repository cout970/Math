package com.cout970.math

import com.cout970.math.vec3.*
import kotlin.test.Test
import kotlin.test.*

class Vec3Tests {

    @Test
    fun constructors() {
        assertEquals(ImmVec3f(), ImmVec3f(0f, 0f, 0f))
        assertEquals(ImmVec3f(1f), ImmVec3f(1f, 1f, 1f))
        assertEquals(ImmVec3f(1f, 1f), ImmVec3f(1f, 1f, 0f))
        assertEquals(ImmVec3f(1f, 1f, 1f), ImmVec3f(1f, 1f, 1f))
        assertEquals(ImmVec3f(x = 1f), ImmVec3f(1f, 0f, 0f))
        assertEquals(ImmVec3f(y = 1f), ImmVec3f(0f, 1f, 0f))
        assertEquals(ImmVec3f(z = 1f), ImmVec3f(0f, 0f, 1f))

        assertEquals(MutVec3f(), MutVec3f(0f, 0f, 0f))
        assertEquals(MutVec3f(1f), MutVec3f(1f, 1f, 1f))
        assertEquals(MutVec3f(1f, 1f), MutVec3f(1f, 1f, 0f))
        assertEquals(MutVec3f(1f, 1f, 1f), MutVec3f(1f, 1f, 1f))
        assertEquals(MutVec3f(x = 1f), MutVec3f(1f, 0f, 0f))
        assertEquals(MutVec3f(y = 1f), MutVec3f(0f, 1f, 0f))
        assertEquals(MutVec3f(z = 1f), MutVec3f(0f, 0f, 1f))

        assertEquals(ImmVec3i(), ImmVec3i(0, 0, 0))
        assertEquals(ImmVec3i(1), ImmVec3i(1, 1, 1))
        assertEquals(ImmVec3i(1, 1), ImmVec3i(1, 1, 0))
        assertEquals(ImmVec3i(1, 1, 1), ImmVec3i(1, 1, 1))
        assertEquals(ImmVec3i(x = 1), ImmVec3i(1, 0, 0))
        assertEquals(ImmVec3i(y = 1), ImmVec3i(0, 1, 0))
        assertEquals(ImmVec3i(z = 1), ImmVec3i(0, 0, 1))

        assertEquals(MutVec3i(), MutVec3i(0, 0, 0))
        assertEquals(MutVec3i(1), MutVec3i(1, 1, 1))
        assertEquals(MutVec3i(1, 1), MutVec3i(1, 1, 0))
        assertEquals(MutVec3i(1, 1, 1), MutVec3i(1, 1, 1))
        assertEquals(MutVec3i(x = 1), MutVec3i(1, 0, 0))
        assertEquals(MutVec3i(y = 1), MutVec3i(0, 1, 0))
        assertEquals(MutVec3i(z = 1), MutVec3i(0, 0, 1))

        assertEquals(ImmVec3d(), ImmVec3d(0.0, 0.0, 0.0))
        assertEquals(ImmVec3d(1.0), ImmVec3d(1.0, 1.0, 1.0))
        assertEquals(ImmVec3d(1.0, 1.0), ImmVec3d(1.0, 1.0, 0.0))
        assertEquals(ImmVec3d(1.0, 1.0, 1.0), ImmVec3d(1.0, 1.0, 1.0))
        assertEquals(ImmVec3d(x = 1.0), ImmVec3d(1.0, 0.0, 0.0))
        assertEquals(ImmVec3d(y = 1.0), ImmVec3d(0.0, 1.0, 0.0))
        assertEquals(ImmVec3d(z = 1.0), ImmVec3d(0.0, 0.0, 1.0))

        assertEquals(MutVec3d(), MutVec3d(0.0, 0.0, 0.0))
        assertEquals(MutVec3d(1.0), MutVec3d(1.0, 1.0, 1.0))
        assertEquals(MutVec3d(1.0, 1.0), MutVec3d(1.0, 1.0, 0.0))
        assertEquals(MutVec3d(1.0, 1.0, 1.0), MutVec3d(1.0, 1.0, 1.0))
        assertEquals(MutVec3d(x = 1.0), MutVec3d(1.0, 0.0, 0.0))
        assertEquals(MutVec3d(y = 1.0), MutVec3d(0.0, 1.0, 0.0))
        assertEquals(MutVec3d(z = 1.0), MutVec3d(0.0, 0.0, 1.0))
    }

    @Test
    fun add() {
        assertEquals(ImmVec3f(x = 1f) + ImmVec3f(1f, 1f, 1f), ImmVec3f(2f, 1f, 1f))
        assertEquals(ImmVec3f(x = 1f) + MutVec3f(1f, 1f, 1f), ImmVec3f(2f, 1f, 1f))
        assertEquals(MutVec3f(x = 1f) + MutVec3f(1f, 1f, 1f), ImmVec3f(2f, 1f, 1f))
        assertEquals(MutVec3f(x = 1f) + ImmVec3f(1f, 1f, 1f), ImmVec3f(2f, 1f, 1f))
    }

    @Test
    fun testEquals() {
        assertEquals<Vec3>(MutVec3f(1f), ImmVec3f(1f))
        assertEquals<Vec3>(ImmVec3f(1f), MutVec3f(1f))

        assertEquals<Vec3>(ImmVec3i(1), MutVec3f(1f))
        assertEquals<Vec3>(ImmVec3f(1f), MutVec3f(1f))
        assertEquals<Vec3>(ImmVec3d(1.0), MutVec3f(1f))

        assertNotEquals<Vec3>(ImmVec3i(1), MutVec3f(1.5f))
        assertEquals<Vec3>(ImmVec3f(1.5f), MutVec3f(1.5f))
        assertEquals<Vec3>(ImmVec3d(1.5), MutVec3f(1.5f))

        assertNotEquals<Vec3>(MutVec3f(1.5f), ImmVec3i(1))
        assertEquals<Vec3>(MutVec3f(1.5f), ImmVec3f(1.5f))
        assertEquals<Vec3>(MutVec3f(1.5f), ImmVec3d(1.5))
    }
}