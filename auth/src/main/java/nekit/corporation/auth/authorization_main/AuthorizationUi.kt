package nekit.corporation.yurtify.authorization.authorization_main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.MutableStateFlow
import nekit.corporation.auth.R
import nekit.corporation.auth.authorization_main.AuthorizationMainComponent
import nekit.corporation.common.R.drawable.yurta_logo
import nekit.corporation.common.theme.YurtifyTheme
import nekit.corporation.yurtify.ui.theme.Background
import nekit.corporation.yurtify.ui.theme.Brown100
import nekit.corporation.yurtify.ui.theme.Brown200
import nekit.corporation.yurtify.ui.theme.Brown300
import nekit.corporation.yurtify.ui.theme.Font
import nekit.corporation.yurtify.ui.theme.Typography

@Composable
fun AuthorizationUi(component: AuthorizationMainComponent) {
    val state by component.state.collectAsState()
    Column(
        Modifier
            .background(Background)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            stringResource(R.string.welcome),
            Modifier.padding(top = 34.dp, bottom = 25.dp),
            style = Typography.labelLarge
        )
        Image(
            ImageBitmap.imageResource(yurta_logo),
            "",
            Modifier
                .weight(1f)
                .padding(horizontal = 28.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            stringResource(R.string.yurtyfi),
            Modifier.offset(y = (-10).dp),
            style = Typography.headlineLarge
        )
        Image(ImageVector.vectorResource(R.drawable.top_ornament), "")
        Text(
            stringResource(R.string.slogan),
            Modifier
                .padding(bottom = 12.dp)
                .padding(horizontal = 64.dp),
            style = Typography.headlineMedium,
            textAlign = TextAlign.Center
        )
        Image(ImageVector.vectorResource(R.drawable.bottom_ornament), "")
        Button(
            component::onSignInClick,
            Modifier
                .padding(horizontal = 44.dp)
                .padding(top = 11.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors().copy(
                containerColor = Brown300
            ),
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 5.dp,
            ),
            shape = RoundedCornerShape(10.dp),
            contentPadding = PaddingValues(vertical = 20.dp)
        ) {
            Text(
                stringResource(R.string.sign_in), style = Typography.bodyMedium
            )
        }
        Button(
            component::onSignUpClick,
            Modifier
                .padding(horizontal = 44.dp, vertical = 23.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors().copy(
                containerColor = Brown100
            ),
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 5.dp,
            ),
            shape = RoundedCornerShape(10.dp),
            contentPadding = PaddingValues(vertical = 20.dp)
        ) {
            Text(
                stringResource(R.string.sign_up), style = Typography.bodyMedium
            )
        }

        TextSeparation(stringResource(R.string.or), Modifier.padding(horizontal = 44.dp))
        Button(
            component::onSignUpAsGuestClick,
            Modifier
                .padding(horizontal = 44.dp)
                .padding(top = 22.dp, bottom = 50.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors().copy(
                containerColor = Brown200
            ),
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 5.dp,
            ),
            shape = RoundedCornerShape(10.dp),
            contentPadding = PaddingValues(vertical = 20.dp)
        ) {
            Text(
                stringResource(R.string.continue_as_guest), style = Typography.bodyMedium
            )
        }

    }
}

@Composable
fun TextSeparation(text: String, modifier: Modifier) {
    Row(modifier, Arrangement.Center, Alignment.CenterVertically) {
        HorizontalDivider(Modifier.weight(1f), color = Font)
        Text(text, Modifier.weight(1f), textAlign = TextAlign.Center, style = Typography.labelSmall)
        HorizontalDivider(Modifier.weight(1f), color = Font)
    }
}

class FakeAuthorizationComponent : AuthorizationMainComponent {
    override val state = MutableStateFlow(AuthorizationState(false))


    override fun onSignInClick() {
        TODO("Not yet implemented")
    }

    override fun onSignUpClick() {
        TODO("Not yet implemented")
    }

    override fun onSignUpAsGuestClick() {
        TODO("Not yet implemented")
    }

    @Preview(showBackground = true, device = Devices.PIXEL_6, showSystemUi = true)
    @Composable
    fun PreviewAuthorizationUi() {
        YurtifyTheme {
            AuthorizationUi(this)
        }
    }
}