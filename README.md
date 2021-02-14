# Kotlin Math Library

This is a Kotlin multiplatform library for math related utilities, contains vectors, quaternions, matrices and more.

### Included features

- Vectors
    - Mutable and immutable
    - 2D, 3D, and 4D
    - Int, Float and Double variants
    - Interfaces to filter instances by properties
    - Extension based utilities, create or reuse vector classes and get all the utilities for free
- Quaternions
    - Constructors from common rotation representations
    - Lots of utilities to compose and apply rotations
    - Extension based utilities, create or reuse quaternion classes and get all the utilities for free
- Multiplatform support
    - Everything is written in common Kotlin, the standard library is the only dependency
    - No platform specific code
    - JVM, JS and Native targets
- Optimized for performance and minimal impact with the JVM garbage collector

### Vectors

The library support mutable and immutable vectors, they are prefixed with Mut and Imm and implement specific interfaces
like ImmVec3 and MutVec3. The name of a vector denotes the combination of each of the previous properties, for example,
MutVec3f is mutable 3d vector of floats

The following tree shows the hierarchy of the interface Vec3:

```
Vec3
|
+ -- Vec3f
|    + ImmVec3f : ImmVec3 
|    + MutVec3f : MutVec3
+ -- Vec3i
|    + ImmVec3i : ImmVec3
|    + MutVec3i : MutVec3
+ -- Vec3d
     + ImmVec3d : ImmVec3
     + MutVec3d : MutVec3
```

In the tree we cna see that ImmVec3i extends ImmVec3 and Vec3i, and Vec3i extends Vec3.

All the intermediary interfaces allow fine control over function parameters and property values, for example:

- Vec3 allow any vector with exactly 3 components of any kind, mutable or not
- Vec3f allows any vector with exactly 3 float components, mutable or not
- MutVec3 allows any mutable vector with 3 components of any kind
- ImmVec3d allows exactly an immutable vector with 3 double components

Vec3 and Vec3f are readonly interfaces, the underlying implementation can be mutable. ImmVec3 marks that a vector is
truly immutable, while MutVec3 indicates that the vector is mutable and provides setters to mutate each component

The classes that implement the interfaces are private and factory methods, with the same name as the interfaces, are
provided to create new instances.

### Extensibility
Every vector is only accessible through an interface and every utility is implemented with extensions, this has the
following benefits:
- All calls use static dispatch which avoids the cost of virtual methods
- Allows using import alias to rename functions, ej `import math.vec3.length as norm`
- Share utilities to all the implementations of the same interface reducing boilerplate code
- Allows to reuse the utilities with new implementations of the base interfaces

### Notes
This library is a rewrite of the math utilities in my previous library
at [Libraries](https://github.com/cout970/Libraries)