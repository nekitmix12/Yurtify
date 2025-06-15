package nekit.corporation.yurtify.authorization.sign_in

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SignInComponentImpl(componentContext: ComponentContext) : SignInComponent,
    ComponentContext by componentContext{
    override val state = MutableStateFlow(
        SignInState(
            email = "",
            password = "",
            isLoading = false,
            emailError = null,
            passwordError = null,
            otherError = null
        )
    )
    override fun onEmailEnter(email: String) {
        TODO("Not yet implemented")
    }

    override fun onPasswordEnter(password: String) {
        TODO("Not yet implemented")
    }

    override fun onSignInClick() {
        TODO("Not yet implemented")
    }

}