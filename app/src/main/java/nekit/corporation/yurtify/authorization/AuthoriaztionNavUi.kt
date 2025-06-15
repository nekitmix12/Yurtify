package nekit.corporation.yurtify.authorization

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import nekit.corporation.yurtify.authorization.authorization_main.AuthorizationUi
import nekit.corporation.yurtify.authorization.sign_in.SignInUi
import nekit.corporation.yurtify.authorization.sign_up.SignUpUi

@Composable
fun AuthorizationNavUi(component: AuthorizationComponent) {
    Children(component.stack) {
        when (val instance = it.instance) {
            is AuthorizationComponent.Child.AuthorizationChild -> AuthorizationUi(instance.component)
            is AuthorizationComponent.Child.SignInChild -> SignInUi(instance.component)
            is AuthorizationComponent.Child.SignUpChild -> SignUpUi(instance.component)
        }
    }
}