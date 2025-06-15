package nekit.corporation.yurtify.authorization

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import nekit.corporation.yurtify.authorization.authorization_main.AuthorizationMainComponentImpl
import nekit.corporation.yurtify.authorization.sign_in.SignInComponentImpl
import nekit.corporation.yurtify.authorization.sign_up.SignUpComponentImpl

interface AuthorizationComponent {
    val stack: Value<ChildStack<*, Child>>


    sealed interface Child {
        class SignUpChild(val component: SignUpComponentImpl) : Child
        class SignInChild(val component: SignInComponentImpl) : Child
        class AuthorizationChild(val component: AuthorizationMainComponentImpl) : Child
    }

}