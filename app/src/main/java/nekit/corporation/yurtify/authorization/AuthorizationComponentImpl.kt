package nekit.corporation.yurtify.authorization

import android.os.Parcelable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import kotlinx.parcelize.Parcelize
import nekit.corporation.yurtify.authorization.authorization_main.AuthorizationMainComponentImpl
import nekit.corporation.yurtify.authorization.sign_in.SignInComponentImpl
import nekit.corporation.yurtify.authorization.sign_up.SignUpComponentImpl

class AuthorizationComponentImpl(
    componentContext: ComponentContext, val onCompete: () -> Unit

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
            SignInComponentImpl(
                componentContext = componentContext,
            )
        )

        is ChildConfig.SignUp -> AuthorizationComponent.Child.SignUpChild(
            SignUpComponentImpl(
                componentContext = componentContext,
            )
        )

        ChildConfig.Authorization -> AuthorizationComponent.Child.AuthorizationChild(
            AuthorizationMainComponentImpl(
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