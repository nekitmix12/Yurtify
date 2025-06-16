package nekit.corporation.yurtify

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import nekit.corporation.auth.AuthorizationNavUi
import nekit.corporation.yurtify.element.ElementUi
import nekit.corporation.yurtify.main.MainUi

@Composable
fun RootUi(component: RootComponent) {
    val stack by component.stack.subscribeAsState()

    Children(stack) {
        when (val instance = it.instance) {
            is RootComponent.Child.MainChild -> MainUi(instance.component)
            is RootComponent.Child.ElementChild -> ElementUi(instance.component)
            is RootComponent.Child.AuthorizationChild -> AuthorizationNavUi(instance.component)
            else -> {}
        }
    }
}