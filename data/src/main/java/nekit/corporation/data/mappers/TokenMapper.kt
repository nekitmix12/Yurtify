package nekit.corporation.data.mappers

import nekit.corporation.data.dto.RefreshRequestDto
import nekit.corporation.data.dto.TokenResponseDto
import nekit.corporation.domain.models.RefreshRequest
import nekit.corporation.domain.models.TokenResponse

fun TokenResponseDto.toTokenResponse() = TokenResponse(accessToken, refreshToken)

fun RefreshRequest.toRefreshRequestDto() = RefreshRequestDto(refreshToken)