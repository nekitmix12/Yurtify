package nekit.corporation.yurtify

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import kotlinx.serialization.Serializable
import nekit.corporation.yurtify.authorization.AuthorizationComponentImpl
import nekit.corporation.yurtify.element.ElementComponentImpl
import nekit.corporation.yurtify.main.MainComponentImpl

class RootComponentImpl(
    componentContext: ComponentContext,

    ) : RootComponent,
    ComponentContext by componentContext {
    private val navigation = StackNavigation<ChildConfig>()
    override val stack = childStack(
        source = navigation,
        serializer = ChildConfig.serializer(),
        initialConfiguration = ChildConfig.Authorization,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        config: ChildConfig, componentContext: ComponentContext
    ): RootComponent.Child = when (config) {
        is ChildConfig.Authorization ->
            RootComponent.Child.AuthorizationChild(
                AuthorizationComponentImpl(
                    componentContext = componentContext,
                    onCompete = { navigation.push(ChildConfig.Main) })
            )

        is ChildConfig.Element -> RootComponent.Child.ElementChild(
            ElementComponentImpl(componentContext)
        )

        is ChildConfig.Main -> RootComponent.Child.MainChild(
            MainComponentImpl(componentContext)
        )
    }

    @Serializable
    sealed interface ChildConfig {

        @Serializable
        data object Authorization : ChildConfig

        @Serializable
        data object Main : ChildConfig

        @Serializable
        data class Element(val elementId: String) : ChildConfig

    }
}