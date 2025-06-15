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
        LazyColumn(Modifier.padding(vertical = 32.dp).weight(1f)) {
            item {
                EditForm(
                    stringResource(R.string.surname),
                    Modifier
                        .padding(horizontal = 26.dp)
                        .padding(bottom = 24.dp),
                    component::onSurnameEnter
                )
            }
            item {
                EditForm(
                    stringResource(R.string.name),
                    Modifier
                        .padding(horizontal = 26.dp)
                        .padding(bottom = 24.dp),
                    component::onNameEnter
                )
            }
            item {
                EditForm(
                    stringResource(R.string.last_name),
                    Modifier
                        .padding(horizontal = 26.dp)
                        .padding(bottom = 24.dp),
                    component::onLastNameEnter
                )
            }
            item {
                EditForm(
                    stringResource(R.string.phone_number),
                    Modifier
                        .padding(horizontal = 26.dp)
                        .padding(bottom = 24.dp),
                    component::onPhoneNumberEnter
                )
            }
            item {
                EditForm(
                    stringResource(R.string.email),
                    Modifier
                        .padding(horizontal = 26.dp)
                        .padding(bottom = 24.dp),
                    component::onEmailEnter
                )
            }
            item {
                EditForm(
                    stringResource(R.string.password),
                    Modifier
                        .padding(horizontal = 26.dp)
                        .padding(bottom = 24.dp),
                    component::onPasswordEnter
                )
            }
            item {
                EditForm(
                    stringResource(R.string.repeat_password),
                    Modifier
                        .padding(horizontal = 26.dp)
                        .padding(bottom = 32.dp),
                    component::onRepeatPasswordEnter
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

@Composable
fun EditForm(
    text: String, @SuppressLint("ModifierParameter") modifier: Modifier, onChange: (String) -> Unit
) {

    OutlinedTextField(
        value = text,
        onValueChange = onChange,
        shape = RoundedCornerShape(10.dp),
        modifier = modifier.fillMaxWidth(),
        placeholder = { Text("Фамилия") },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Beige,
            focusedContainerColor = Beige.copy(alpha = 0.9f),
            unfocusedBorderColor = Gray,
            focusedBorderColor = Gray,
            focusedTextColor = Font.copy(alpha = 0.4f),
            unfocusedTextColor = Font.copy(alpha = 0.3f),
            focusedPlaceholderColor = Font.copy(alpha = 0.4f),
            unfocusedPlaceholderColor = Font.copy(alpha = 0.3f),
        ),
        textStyle = Typography.bodySmall
    )
}

@Composable
fun ConfirmButton(onClick: () -> Unit, text: String, modifier: Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors().copy(
            containerColor = Brown300
        ),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 5.dp,
        ),
        shape = RoundedCornerShape(10.dp),
    ) {
        Text(text, Modifier.padding(vertical = 10.dp), style = Typography.bodyMedium)
    }
}

class FakeSignUpComponent : SignUpComponent {
    override val state = MutableStateFlow(
        SignUpState(
            surname = "",
            name = "",
            lastName = "",
            phoneNumber = "",
            email = "",
            password = "",
            repeatPassword = "",
            loading = false,
            surnameError = null,
            nameError = null,
            lastNameError = null,
            phoneNumberError = null,
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
