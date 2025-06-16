package nekit.corporation.data.dto

data class UserDto(
    val id: String,
    val email: String,
    val fullName: UserFullNameDto,
    val phone: String
)
