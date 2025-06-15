package nekit.corporation.yurtify.authorization.sign_in

data class SignInState(
    val email: String,
    val password: String,
    val isLoading: Boolean,
    val emailError:String?,
    val passwordError: String?,
    val otherError: String?,

)
