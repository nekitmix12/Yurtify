package nekit.corporation.auth.sign_up

import com.arkivanov.decompose.ComponentContext
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import me.gulya.anvil.assisted.ContributesAssistedFactory
import nekit.corporation.auth.AuthorizationComponent
import nekit.corporation.common.AppScope
import nekit.corporation.domain.usecases.RegisterUseCase
import nekit.corporation.domain.usecases.ValidateRegisterFormUseCase

@ContributesAssistedFactory(AppScope::class, SignUpComponent.Factory::class)
class SignUpComponentImpl @AssistedInject constructor(
    @Assisted componentContext: ComponentContext,
    private val validateRegisterFormUseCase: ValidateRegisterFormUseCase,
    private val registerUseCase: RegisterUseCase
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