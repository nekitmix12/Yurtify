package nekit.corporation.data.dto

data class RegisterRequestDto(
    val email: String,
    val password: String,
    val fullName: UserFullNameDto,
    val phone: String
)
