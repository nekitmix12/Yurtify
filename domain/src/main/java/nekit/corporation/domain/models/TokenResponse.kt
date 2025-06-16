package nekit.corporation.domain.models

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
)
