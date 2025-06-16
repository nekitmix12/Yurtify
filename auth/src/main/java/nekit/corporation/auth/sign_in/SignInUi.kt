package nekit.corporation.auth.sign_in

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.MutableStateFlow
import nekit.corporation.auth.R
import nekit.corporation.common.R.drawable.yurta_logo
import nekit.corporation.yurtify.authorization.sign_in.SignInState
import nekit.corporation.yurtify.ui.theme.Background
import nekit.corporation.yurtify.ui.theme.Typography
import nekit.corporation.yurtify.ui_kit.ConfirmButton
import nekit.corporation.yurtify.ui_kit.EditForm

@Composable
fun SignInUi(component: SignInComponent) {
    val state by component.state.collectAsState()

    Column(
        Modifier
            .fillMaxSize()
            .background(Background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            stringResource(R.string.sign_in),
            Modifier.padding(top = 34.dp, bottom = 16.dp),
            style = Typography.labelLarge
        )
        Image(
            ImageBitmap.imageResource(yurta_logo),
            "",
            Modifier
                .weight(0.4f)
                .padding(horizontal = 38.dp, vertical = 40.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.weight(0.1f))
        EditForm(
            state.email,
            stringResource(R.string.email),
            Modifier.padding(horizontal = 26.dp),
            component::onEmailEnter,
            state.emailError
        )
        EditForm(
            state.password,
            stringResource(R.string.password),
            Modifier.padding(vertical = 24.dp, horizontal = 26.dp),
            component::onPasswordEnter,
            state.passwordError
        )
        ConfirmButton(
            component::onSignInClick,
            stringResource(R.string.sign_in_v),
            Modifier.padding(horizontal = 26.dp)
        )
        Spacer(Modifier.weight(0.2f))

    }
}

class FakeSignInComponent : SignInComponent {
    override val state = MutableStateFlow(
        SignInState(
            email = "",
            password = "",
            isLoading = false,
            emailError = null,
            passwordError = null,
            otherError = null
        )
    )

    override fun onEmailEnter(email: String) {
        TODO("Not yet implemented")
    }

    override fun onPasswordEnter(password: String) {
        TODO("Not yet implemented")
    }

    override fun onSignInClick() {
        TODO("Not yet implemented")
    }

    @Preview(showBackground = true, device = Devices.PIXEL_6, showSystemUi = true)
    @Composable
    fun PreviewSignInUi() {
        SignInUi(this)
    }
}