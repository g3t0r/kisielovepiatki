package pl.kisielovepiatki.backend.validator.impl

import pl.kisielovepiatki.backend.validator.EmptyValidator
import pl.kisielovepiatki.backend.validator.ValidationResult

class EmptyValidatorImpl<Any> : EmptyValidator<Any>, GenericValidatorImpl<Any>() {
    override fun isValid(obj: Any): ValidationResult {
        return ValidationResult(true, null)
    }
}
