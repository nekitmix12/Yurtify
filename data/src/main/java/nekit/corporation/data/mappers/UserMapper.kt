package nekit.corporation.data.mappers

import nekit.corporation.data.dto.LoginRequestDto
import nekit.corporation.data.dto.RegisterRequestDto
import nekit.corporation.data.dto.UserFullNameDto
import nekit.corporation.domain.models.LoginRequest
import nekit.corporation.domain.models.RegisterRequest
import nekit.corporation.domain.models.UserFullName

fun RegisterRequest.toRegisterRequestDto() =
    RegisterRequestDto(email, password, fullName.toUserFullNameDto(), phone)

fun UserFullName.toUserFullNameDto() = UserFullNameDto(name, surname, patronymic)

fun LoginRequest.toLoginRequestDto() = LoginRequestDto(email, password)
