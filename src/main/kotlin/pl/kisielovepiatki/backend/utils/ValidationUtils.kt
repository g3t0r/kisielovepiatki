package pl.kisielovepiatki.backend.utils

import pl.kisielovepiatki.backend.validator.ValidationResult

class ValidationUtils {
    companion object {
        fun validateAll(validations: List<Validation>): ValidationResult {
            val it = validations.iterator()
            var result = ValidationResult(true, null)

            while (it.hasNext() && result.isValid) {
                result = it.next().invoke(Unit)
            }

            return result
        }
    }
}

typealias Validation = (Unit) -> ValidationResult
