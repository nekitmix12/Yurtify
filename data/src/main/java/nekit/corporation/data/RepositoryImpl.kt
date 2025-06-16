package nekit.corporation.data

import com.squareup.anvil.annotations.ContributesBinding
import com.squareup.anvil.annotations.optional.SingleIn
import nekit.corporation.common.AppScope
import nekit.corporation.data.mappers.toLoginRequestDto
import nekit.corporation.data.mappers.toRegisterRequestDto
import nekit.corporation.data.mappers.toTokenResponse
import nekit.corporation.domain.repository.Repository
import nekit.corporation.domain.models.LoginRequest
import nekit.corporation.domain.models.RegisterRequest
import nekit.corporation.domain.models.TokenResponse
import nekit.corporation.yurtify.data.api.ApiAuth
import javax.inject.Inject

@SingleIn(AppScope::class)
@ContributesBinding(AppScope::class)
class RepositoryImpl @Inject constructor(private val apiAuth: ApiAuth) :
    Repository {
    override fun register(registerRequest: RegisterRequest): TokenResponse =
        apiAuth.register(registerRequest.toRegisterRequestDto()).toTokenResponse()

    override fun login(loginRequest: LoginRequest): TokenResponse =
        apiAuth.login(loginRequest.toLoginRequestDto()).toTokenResponse()

}