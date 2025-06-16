package nekit.corporation.domain.models

data class RegisterRequest(
    val email: String,
    val password: String,
    val confirmPassword: String,
    val fullName: UserFullName,
    val phone: String
)
