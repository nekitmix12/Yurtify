package nekit.corporation.yurtify.element

import com.arkivanov.decompose.ComponentContext
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import me.gulya.anvil.assisted.ContributesAssistedFactory
import nekit.corporation.common.AppScope

@ContributesAssistedFactory(AppScope::class, ElementComponent.Factory::class)
class ElementComponentImpl @AssistedInject constructor(@Assisted componentContext: ComponentContext) : ElementComponent,
    ComponentContext by componentContext