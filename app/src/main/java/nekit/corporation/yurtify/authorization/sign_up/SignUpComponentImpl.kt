package nekit.corporation.yurtify.authorization.sign_up

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.MutableStateFlow

class SignUpComponentImpl(
    componentContext: ComponentContext,

    ) : SignUpComponent,
    ComponentContext by componentContext {
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
}