package nekit.corporation.yurtify.element

import com.arkivanov.decompose.ComponentContext

interface ElementComponent {
    fun interface Factory {
        operator fun invoke(componentContext: ComponentContext): ElementComponent
    }
}