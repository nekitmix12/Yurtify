package nekit.corporation.auth.sign_up

data class SignUpState(
    val surname: String,
    val surnameError: String?,
    val name: String,
    val nameError: String?,
    val lastNameError: String?,
    val lastName: String,
    val phoneNumber: String,
    val phoneNumberError: String?,
    val email: String,
    val emailError: String?,
    val password: String,
    val passwordError: String?,
    val repeatPassword: String,
    val repeatPasswordError: String?,
    val loading: Boolean
)
