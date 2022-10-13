package io.sirix.ktsirix

import java.time.Instant

data class AccessToken(
    val value: String,
    val expirationTime: Instant = Instant.now(),
    val refreshToken: String
) {
    fun isNotExpired() = Instant.now() < expirationTime
}

data class AccessTokenResponse(
    val accessToken: String,
    val expiresIn: Long,
    val refreshToken: String
) {
    fun toAccessToken() = AccessToken(
        accessToken,
        expirationTime = Instant.now().plusSeconds(expiresIn),
        refreshToken
    )
}
