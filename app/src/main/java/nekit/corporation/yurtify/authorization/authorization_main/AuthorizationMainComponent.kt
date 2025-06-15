package nekit.corporation.yurtify.authorization.authorization_main

import kotlinx.coroutines.flow.StateFlow

interface AuthorizationMainComponent {
    val state: StateFlow<AuthorizationState>
    fun onSignInClick()
    fun onSignUpClick()
    fun onSignUpAsGuestClick()
}