package pl.kisielovepiatki.backend.validator.impl

import pl.kisielovepiatki.backend.exception.ValidationFailedException
import pl.kisielovepiatki.backend.validator.GenericValidator
import pl.kisielovepiatki.backend.validator.ValidationResult
import java.util.function.Consumer
import java.util.function.Supplier

abstract class GenericValidatorImpl<T> : GenericValidator<T> {

    override fun ifValid(obj: T, then: Consumer<T>) {
        val result: ValidationResult = isValid(obj)
        if (result.isValid) {
            then.accept(obj)
        } else {
            throw ValidationFailedException((result.failureReason ?: "unknown"))
        }
    }
}
