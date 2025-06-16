package nekit.corporation.domain.usecases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import nekit.corporation.common.Error
import nekit.corporation.domain.models.RegisterRequest
import nekit.corporation.domain.validator.EmailValidate
import nekit.corporation.domain.validator.NameValidate
import nekit.corporation.domain.validator.SurnameValidate
import nekit.corporation.domain.validator.ValidateConfirmPassword
import nekit.corporation.domain.validator.ValidatePassword
import javax.inject.Inject

class ValidateRegisterFormUseCase @Inject constructor(
    @Inject private val nameValidate: NameValidate,
    @Inject private val surnameValidate: SurnameValidate,
    @Inject private val emailValidate: EmailValidate,
    @Inject private val password: ValidatePassword,
    @Inject private val confirmPassword: ValidateConfirmPassword,
    configuration: Configuration = Configuration(Dispatchers.Default)
) : UseCase<ValidateRegisterFormUseCase.Request, ValidateRegisterFormUseCase.Response>(configuration) {

    data class Request(val registerRequest: RegisterRequest) : UseCase.Request
    data class Response(val errors: List<Error>) : UseCase.Response

    override fun process(request: Request): Flow<Response> {
        val result = mutableListOf<Error>()
        nameValidate.validate(request.registerRequest.fullName.name)?.let { result.add(it) }
        surnameValidate.validate(request.registerRequest.fullName.surname)?.let { result.add(it) }
        emailValidate.validate(request.registerRequest.email)?.let { result.add(it) }
        password.validate(request.registerRequest.password)?.let { result.add(it) }
        confirmPassword.validate(
            request.registerRequest.password,
            request.registerRequest.confirmPassword
        )?.let { result.add(it) }
        return flowOf(Response(result))
    }

}