package nekit.corporation.yurtify.main

import com.arkivanov.decompose.ComponentContext

class MainComponentImpl(componentContext: ComponentContext) : MainComponent,
    ComponentContext by componentContext