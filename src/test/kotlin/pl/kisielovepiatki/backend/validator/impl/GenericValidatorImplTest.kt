package pl.kisielovepiatki.backend.validator.impl

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import pl.kisielovepiatki.backend.exception.ValidationFailedException
import pl.kisielovepiatki.backend.validator.ValidationResult

internal class GenericValidatorImplTest {

    @Test
    fun ifValid__success() {
        val genericValidator = object : GenericValidatorImpl<Any>() {
            override fun isValid(obj: Any): ValidationResult {
                return ValidationResult(true, null)
            }

        }
        var counter: Short = 0;

        Assertions.assertDoesNotThrow() {
            genericValidator.ifValid(
                Any()
            ) {
                counter = (counter + 1).toShort()
            }
        }

        Assertions.assertEquals(1, counter)
    }

    @Test
    fun ifValid__failure() {
        val genericValidator = object : GenericValidatorImpl<Any>() {
            override fun isValid(obj: Any): ValidationResult {
                return ValidationResult(false, "some reason")
            }

        }
        var counter: Short = 0;

        Assertions.assertThrows(ValidationFailedException::class.java,{
            genericValidator.ifValid(
                Any()
            ) {
                counter = (counter + 1).toShort()
            }
        },"some reason")

        Assertions.assertEquals(0, counter)
    }
}
