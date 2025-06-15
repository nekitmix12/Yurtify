package nekit.corporation.yurtify.authorization.sign_in

import kotlinx.coroutines.flow.StateFlow

interface SignInComponent {
    val state: StateFlow<SignInState>

    fun onEmailEnter(email: String)

    fun onPasswordEnter(password: String)

    fun onSignInClick()
}