package nekit.corporation.yurtify.authorization.authorization_main

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.MutableStateFlow

class AuthorizationMainComponentImpl(
    componentContext: ComponentContext,
    val goToSignIn: () -> Unit,
    val goToSignUp: () -> Unit
) :
    AuthorizationMainComponent, ComponentContext by componentContext {
    override val state = MutableStateFlow(AuthorizationState(false))

    override fun onSignInClick() = goToSignIn()

    override fun onSignUpClick() = goToSignUp()

    override fun onSignUpAsGuestClick() {
    }
}