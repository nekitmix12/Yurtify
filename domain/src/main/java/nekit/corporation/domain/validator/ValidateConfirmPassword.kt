package nekit.corporation.domain.validator

import nekit.corporation.common.Error
import nekit.corporation.domain.DifferentPasswords
import javax.inject.Inject

class ValidateConfirmPassword @Inject constructor(){
    fun validate(password: String, confirmPassword: String): Error? {
        return if (password != confirmPassword) DifferentPasswords else null
    }
}