package nekit.corporation.yurtify

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.serialization.Serializable
import me.gulya.anvil.assisted.ContributesAssistedFactory
import nekit.corporation.auth.AuthorizationComponent
import nekit.corporation.common.AppScope
import nekit.corporation.yurtify.element.ElementComponent
import nekit.corporation.yurtify.main.MainComponent

@ContributesAssistedFactory(AppScope::class, RootComponent.Factory::class)
class RootComponentImpl @AssistedInject constructor(
    private val authorizationFactory: AuthorizationComponent.Factory,
    private val elementFactory: ElementComponent.Factory,
    private val mainFactory: MainComponent.Factory,
    @Assisted componentContext: ComponentContext,
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
                authorizationFactory(
                    componentContext = componentContext,
                    onComplete = { navigation.push(ChildConfig.Main) })
            )

        is ChildConfig.Element -> RootComponent.Child.ElementChild(
            elementFactory(componentContext = componentContext)
        )

        is ChildConfig.Main -> RootComponent.Child.MainChild(
            mainFactory(componentContext = componentContext)
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