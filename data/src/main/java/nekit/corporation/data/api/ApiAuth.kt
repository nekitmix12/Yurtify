package nekit.corporation.yurtify.data.api

import nekit.corporation.data.dto.LoginRequestDto
import nekit.corporation.data.dto.RefreshRequestDto
import nekit.corporation.data.dto.RegisterRequestDto
import nekit.corporation.data.dto.TokenResponseDto
import retrofit2.http.POST

interface ApiAuth {

    @POST
    fun register(registerRequestDto: RegisterRequestDto): TokenResponseDto

    @POST
    fun refresh(refreshRequestDto: RefreshRequestDto): TokenResponseDto

    @POST
    fun logout()

    @POST
    fun login(loginRequestDto: LoginRequestDto): TokenResponseDto

}