package nekit.corporation.auth

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import nekit.corporation.auth.authorization_main.AuthorizationMainComponent
import nekit.corporation.auth.sign_in.SignInComponent
import nekit.corporation.auth.sign_up.SignUpComponent

interface AuthorizationComponent {
    val stack: Value<ChildStack<*, Child>>


    sealed interface Child {
        class SignUpChild(val component: SignUpComponent) : Child
        class SignInChild(val component: SignInComponent) : Child
        class AuthorizationChild(val component: AuthorizationMainComponent) : Child
    }

    fun interface Factory {
        operator fun invoke(
            componentContext: ComponentContext,
            onComplete: () -> Unit,
        ): AuthorizationComponent
    }
}