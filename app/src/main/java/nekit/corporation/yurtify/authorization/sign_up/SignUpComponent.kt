package nekit.corporation.yurtify.authorization.sign_up

import kotlinx.coroutines.flow.StateFlow

interface SignUpComponent {
    val state: StateFlow<SignUpState>
    fun onSurnameEnter(surname: String)
    fun onNameEnter(name: String)
    fun onLastNameEnter(lastName: String)
    fun onPhoneNumberEnter(phoneNumber: String)
    fun onEmailEnter(email: String)
    fun onPasswordEnter(password: String)
    fun onRepeatPasswordEnter(repeatPassword: String)
    fun signUp()
}