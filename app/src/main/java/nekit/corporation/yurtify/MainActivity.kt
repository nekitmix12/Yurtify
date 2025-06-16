package nekit.corporation.yurtify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arkivanov.decompose.defaultComponentContext
import nekit.corporation.common.theme.YurtifyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component =
            DaggerAppDaggerComponent.create().rootComponentFactory(defaultComponentContext())
        enableEdgeToEdge()
        setContent {
            YurtifyTheme {
                RootUi(component)
            }
        }
    }
}

