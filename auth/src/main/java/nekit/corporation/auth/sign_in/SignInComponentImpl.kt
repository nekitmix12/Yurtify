package nekit.corporation.auth.sign_in

import com.arkivanov.decompose.ComponentContext
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import me.gulya.anvil.assisted.ContributesAssistedFactory
import nekit.corporation.auth.authorization_main.AuthorizationMainComponent
import nekit.corporation.common.AppScope
import nekit.corporation.yurtify.authorization.sign_in.SignInState

@ContributesAssistedFactory(AppScope::class, SignInComponent.Factory::class)
class SignInComponentImpl @AssistedInject constructor(@Assisted componentContext: ComponentContext) : SignInComponent,
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