package nekit.corporation.domain.validator

import nekit.corporation.common.Error
import nekit.corporation.domain.ShortName
import javax.inject.Inject

class SurnameValidate@Inject constructor() {
     fun validate(surname: String): Error? {
        return if (surname.isBlank()) ShortName else null
    }
}