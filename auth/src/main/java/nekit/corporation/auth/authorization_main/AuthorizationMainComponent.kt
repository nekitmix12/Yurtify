package nekit.corporation.auth.authorization_main

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.StateFlow
import nekit.corporation.yurtify.authorization.authorization_main.AuthorizationState

interface AuthorizationMainComponent {
    val state: StateFlow<AuthorizationState>

    fun onSignInClick()
    fun onSignUpClick()
    fun onSignUpAsGuestClick()

    fun interface Factory {
        operator fun invoke(
            componentContext: ComponentContext,
            goToSignIn: () -> Unit,
            goToSignUp: () -> Unit
        ): AuthorizationMainComponent
    }
}