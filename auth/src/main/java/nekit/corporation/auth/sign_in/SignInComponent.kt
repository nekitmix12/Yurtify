package nekit.corporation.auth.sign_in

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow
import nekit.corporation.auth.sign_up.SignUpComponent
import nekit.corporation.yurtify.authorization.sign_in.SignInState

interface SignInComponent {
    val state: StateFlow<SignInState>

    fun onEmailEnter(email: String)

    fun onPasswordEnter(password: String)

    fun onSignInClick()

    fun interface Factory {
        operator fun invoke(componentContext: ComponentContext): SignInComponent
    }
}