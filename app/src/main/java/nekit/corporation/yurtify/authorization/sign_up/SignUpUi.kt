package nekit.corporation.yurtify.authorization.sign_up

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.MutableStateFlow
import nekit.corporation.yurtify.R
import nekit.corporation.yurtify.ui.theme.Background
import nekit.corporation.yurtify.ui.theme.Beige
import nekit.corporation.yurtify.ui.theme.Brown300
import nekit.corporation.yurtify.ui.theme.Font
import nekit.corporation.yurtify.ui.theme.Gray
import nekit.corporation.yurtify.ui.theme.Typography
import nekit.corporation.yurtify.ui_kit.ConfirmButton
import nekit.corporation.yurtify.ui_kit.EditForm

@Composable
fun SignUpUi(component: SignUpComponent) {
    val state by component.state.collectAsState()
    Column(
        Modifier
            .background(Background)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            stringResource(R.string.sign_up),
            Modifier.padding(top = 34.dp, bottom = 16.dp),
            style = Typography.labelLarge
        )
        Image(
            ImageBitmap.imageResource(R.drawable.yurta_logo),
            "",
            Modifier
                .weight(0.5f)
                .padding(horizontal = 28.dp),
            contentScale = ContentScale.Crop
        )
        LazyColumn(
            Modifier
                .padding(vertical = 32.dp)
                .weight(1f)
        ) {
            item {
                EditForm(
                    state.surname,
                    stringResource(R.string.surname),
                    Modifier
                        .padding(horizontal = 26.dp)
                        .padding(bottom = 24.dp),
                    component::onSurnameEnter,
                    state.surnameError
                )
            }
            item {
                EditForm(
                    state.name,
                    stringResource(R.string.name),
                    Modifier
                        .padding(horizontal = 26.dp)
                        .padding(bottom = 24.dp),
                    component::onNameEnter,
                    state.nameError
                )
            }
            item {
                EditForm(
                    state.lastName,
                    stringResource(R.string.last_name),
                    Modifier
                        .padding(horizontal = 26.dp)
                        .padding(bottom = 24.dp),
                    component::onLastNameEnter,
                    state.lastNameError
                )
            }
            item {
                EditForm(
                    state.phoneNumber,
                    stringResource(R.string.phone_number),
                    Modifier
                        .padding(horizontal = 26.dp)
                        .padding(bottom = 24.dp),
                    component::onPhoneNumberEnter,
                    state.phoneNumberError
                )
            }
            item {
                EditForm(
                    state.email,
                    stringResource(R.string.email),
                    Modifier
                        .padding(horizontal = 26.dp)
                        .padding(bottom = 24.dp),
                    component::onEmailEnter,
                    state.emailError
                )
            }
            item {
                EditForm(
                    state.password,
                    stringResource(R.string.password),
                    Modifier
                        .padding(horizontal = 26.dp)
                        .padding(bottom = 24.dp),
                    component::onPasswordEnter,
                    state.passwordError
                )
            }
            item {
                EditForm(
                    state.repeatPassword,
                    stringResource(R.string.repeat_password),
                    Modifier
                        .padding(horizontal = 26.dp)
                        .padding(bottom = 32.dp),
                    component::onRepeatPasswordEnter,
                    state.repeatPasswordError
                )
            }

        }

        ConfirmButton(
            component::signUp,
            stringResource(R.string.sign_up_v),
            Modifier
                .padding(horizontal = 34.dp)
                .padding(bottom = 43.dp)
        )
    }
}




class FakeSignUpComponent : SignUpComponent {
    override val state = MutableStateFlow(
        SignUpState(
            surname = "Valera",
            name = "",
            lastName = "",
            phoneNumber = "123",
            email = "",
            password = "",
            repeatPassword = "",
            loading = false,
            surnameError = null,
            nameError = null,
            lastNameError = null,
            phoneNumberError = "Короткий номер",
            emailError = null,
            passwordError = null,
            repeatPasswordError = null,
        )
    )

    override fun onSurnameEnter(surname: String) {
        TODO("Not yet implemented")
    }

    override fun onNameEnter(name: String) {
        TODO("Not yet implemented")
    }

    override fun onLastNameEnter(lastName: String) {
        TODO("Not yet implemented")
    }

    override fun onPhoneNumberEnter(phoneNumber: String) {
        TODO("Not yet implemented")
    }

    override fun onEmailEnter(email: String) {
        TODO("Not yet implemented")
    }

    override fun onPasswordEnter(password: String) {
        TODO("Not yet implemented")
    }

    override fun onRepeatPasswordEnter(repeatPassword: String) {
        TODO("Not yet implemented")
    }

    override fun signUp() {
        TODO("Not yet implemented")
    }

    @Preview(showBackground = true, device = Devices.PIXEL_6, showSystemUi = true)
    @Composable
    fun PreviewSingUpUi() {
        SignUpUi(this)
    }
}
