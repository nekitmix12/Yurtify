package nekit.corporation.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import nekit.corporation.domain.models.LoginRequest
import nekit.corporation.domain.models.TokenResponse
import nekit.corporation.domain.repository.Repository

class LoginUseCase(private val repository: Repository, configuration: Configuration) :
    UseCase<LoginUseCase.Request, LoginUseCase.Response>(configuration) {
    override fun process(request: Request): Flow<Response> =
        flowOf(Response(repository.login(request.loginRequest)))

    data class Request(val loginRequest: LoginRequest) : UseCase.Request
    data class Response(val tokenResponse: TokenResponse) : UseCase.Response


}