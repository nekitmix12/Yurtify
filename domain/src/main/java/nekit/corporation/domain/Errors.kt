package nekit.corporation.domain

import nekit.corporation.common.Error

data object EmptyField : Error
data object InvalidEmail : Error
data object ShortName : Error
data object DifferentPasswords : Error
data object InvalidPassword : Error