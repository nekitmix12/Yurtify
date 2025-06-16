package nekit.corporation.auth

import android.os.Parcelable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.parcelize.Parcelize
import me.gulya.anvil.assisted.ContributesAssistedFactory
import nekit.corporation.auth.sign_in.SignInComponent
import nekit.corporation.auth.sign_up.SignUpComponent
import nekit.corporation.common.AppScope
import nekit.corporation.auth.authorization_main.AuthorizationMainComponent

@ContributesAssistedFactory(AppScope::class, AuthorizationComponent.Factory::class)
class AuthorizationComponentImpl @AssistedInject constructor(
    private val signUpFactory: SignUpComponent.Factory,
    private val signInFactory: SignInComponent.Factory,
    private val authorizationMainComponentFactory: AuthorizationMainComponent.Factory,
    @Assisted componentContext: ComponentContext,
    @Assisted private val onCompete: () -> Unit

) : AuthorizationComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<ChildConfig>()
    override val stack = childStack(
        source = navigation,
        initialConfiguration = ChildConfig.Authorization,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        config: ChildConfig, componentContext: ComponentContext
    ): AuthorizationComponent.Child = when (config) {
        is ChildConfig.SignIn -> AuthorizationComponent.Child.SignInChild(
            signInFactory(
                componentContext = componentContext,
            )
        )

        is ChildConfig.SignUp -> AuthorizationComponent.Child.SignUpChild(
            signUpFactory(
                componentContext = componentContext,
            )
        )

        ChildConfig.Authorization -> AuthorizationComponent.Child.AuthorizationChild(
            authorizationMainComponentFactory(
                componentContext = componentContext,
                goToSignIn = { navigation.push(ChildConfig.SignIn) },
                goToSignUp = { navigation.push(ChildConfig.SignUp) }
            )
        )
    }

    @Parcelize
    sealed interface ChildConfig : Parcelable {

        @Parcelize
        data object SignIn : ChildConfig

        @Parcelize
        data object SignUp : ChildConfig

        @Parcelize
        data object Authorization : ChildConfig
    }
}