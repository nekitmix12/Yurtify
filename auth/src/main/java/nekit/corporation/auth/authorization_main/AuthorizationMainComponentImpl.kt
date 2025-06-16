package nekit.corporation.auth.authorization_main

import com.arkivanov.decompose.ComponentContext
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import me.gulya.anvil.assisted.ContributesAssistedFactory
import nekit.corporation.common.AppScope
import nekit.corporation.yurtify.authorization.authorization_main.AuthorizationState

@ContributesAssistedFactory(AppScope::class, AuthorizationMainComponent.Factory::class)
class AuthorizationMainComponentImpl @AssistedInject constructor(
    @Assisted componentContext: ComponentContext,
    @Assisted val goToSignIn: () -> Unit,
    @Assisted val goToSignUp: () -> Unit
) :
    AuthorizationMainComponent, ComponentContext by componentContext {
    override val state = MutableStateFlow(AuthorizationState(false))

    override fun onSignInClick() = goToSignIn()

    override fun onSignUpClick() = goToSignUp()

    override fun onSignUpAsGuestClick() {
    }
}