package nekit.corporation.yurtify

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import nekit.corporation.yurtify.authorization.AuthorizationComponent
import nekit.corporation.yurtify.element.ElementComponent
import nekit.corporation.yurtify.main.MainComponent

interface RootComponent {
    val stack: Value<ChildStack<*, Child>>

    sealed interface Child {
        class AuthorizationChild(val component: AuthorizationComponent) : Child
        class MainChild(val component: MainComponent) : Child
        class ElementChild(val component: ElementComponent) : Child
    }
}