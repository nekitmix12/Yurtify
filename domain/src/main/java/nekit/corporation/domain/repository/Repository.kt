package nekit.corporation.domain.repository

import nekit.corporation.domain.models.LoginRequest
import nekit.corporation.domain.models.RegisterRequest
import nekit.corporation.domain.models.TokenResponse

interface Repository {
    fun register(registerRequest: RegisterRequest): TokenResponse

    fun login(loginRequest: LoginRequest): TokenResponse
}