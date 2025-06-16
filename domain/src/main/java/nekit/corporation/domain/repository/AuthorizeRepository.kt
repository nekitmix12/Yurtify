package nekit.corporation.domain.repository

import nekit.corporation.domain.models.RefreshRequest
import nekit.corporation.domain.models.TokenResponse

interface AuthorizeRepository {
    fun logout()
    fun refreshToken(refreshRequest: RefreshRequest): TokenResponse

}