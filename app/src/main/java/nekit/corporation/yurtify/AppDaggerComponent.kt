package nekit.corporation.yurtify

import com.squareup.anvil.annotations.MergeComponent
import com.squareup.anvil.annotations.optional.SingleIn
import nekit.corporation.common.AppScope


@SingleIn(AppScope::class)
@MergeComponent(AppScope::class)
interface AppDaggerComponent {
    val rootComponentFactory: RootComponent.Factory
}

