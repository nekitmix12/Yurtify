package nekit.corporation.data

import nekit.corporation.data.mappers.toRefreshRequestDto
import nekit.corporation.data.mappers.toTokenResponse
import nekit.corporation.domain.repository.AuthorizeRepository
import nekit.corporation.domain.models.RefreshRequest
import nekit.corporation.domain.models.TokenResponse
import nekit.corporation.yurtify.data.api.ApiAuth

class AuthorizeRepositoryImpl(@Authorize private val apiAuth: ApiAuth) : AuthorizeRepository {
    override fun logout() = apiAuth.logout()

    override fun refreshToken(refreshRequest: RefreshRequest): TokenResponse =
        apiAuth.refresh(refreshRequest.toRefreshRequestDto()).toTokenResponse()
}