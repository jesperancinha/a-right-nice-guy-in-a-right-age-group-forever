package org.jesperancinha.multiplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform