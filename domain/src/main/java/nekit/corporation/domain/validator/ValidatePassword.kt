package nekit.corporation.domain.validator

import nekit.corporation.common.Error
import nekit.corporation.domain.InvalidPassword
import javax.inject.Inject

class ValidatePassword @Inject constructor() {
    fun validate(password: String): Error? {
        return if (password.any { !it.isLetterOrDigit() } && password.any { it.isDigit() } && password.any { it.isLetter() }) null else InvalidPassword
    }
}