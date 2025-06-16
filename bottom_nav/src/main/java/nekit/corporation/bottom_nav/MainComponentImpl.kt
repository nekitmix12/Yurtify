package nekit.corporation.yurtify.main

import com.arkivanov.decompose.ComponentContext
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import me.gulya.anvil.assisted.ContributesAssistedFactory
import nekit.corporation.common.AppScope

@ContributesAssistedFactory(AppScope::class, MainComponent.Factory::class)
class MainComponentImpl @AssistedInject constructor(@Assisted componentContext: ComponentContext) : MainComponent,
    ComponentContext by componentContext