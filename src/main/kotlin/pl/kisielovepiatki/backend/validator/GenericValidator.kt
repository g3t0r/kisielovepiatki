package pl.kisielovepiatki.backend.validator

import pl.kisielovepiatki.backend.exception.ValidationFailedException
import java.util.function.Consumer
import kotlin.jvm.Throws

/**
 * Interface for validators of certain types,
 * should be used mostly in domain level services
 * due to lack of flexibility
 *
 * @param T type of object to be validated
 * */
interface GenericValidator<T> {
    /**
     * @param obj to be validated
     * @return result of validation
     * @see ValidationResult
     * */
    fun isValid(obj: T): ValidationResult

    /**
     * @param obj object to be validated
     * @param then reference to method/labda to be executed after successful validation
     * */
    @Throws(ValidationFailedException::class)
    fun ifValid(obj: T, then: Consumer<T>)
}

