package nekit.corporation.yurtify.main

import com.arkivanov.decompose.ComponentContext

interface MainComponent {
    fun interface Factory {
        operator fun invoke(componentContext: ComponentContext):MainComponent
    }
}