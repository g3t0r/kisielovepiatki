package pl.kisielovepiatki.backend.validator.impl

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import pl.kisielovepiatki.backend.model.entity.survey.Score
import pl.kisielovepiatki.backend.validator.ValidationResult

internal class ScoreValidatorImplTest {

    @Test
    fun isValid__blankName() {
        val scoreValidator: ScoreValidator = ScoreValidatorImpl();
        val score = Score("    ", 0)

        val result: ValidationResult = scoreValidator.isValid(score)

        Assertions.assertFalse { result.isValid }
        Assertions.assertEquals(
            ScoreValidatorImpl.BLANK_NAME_NOT_ALLOWED_MESSAGE,
            result.failureReason
        )
    }


    @Test
    fun isValid__emptyName() {
        val scoreValidator: ScoreValidator = ScoreValidatorImpl();
        val score = Score("", 0)

        val result: ValidationResult = scoreValidator.isValid(score)

        Assertions.assertFalse { result.isValid }
        Assertions.assertEquals(
            ScoreValidatorImpl.EMPTY_NAME_NOT_ALLOWED_MESSAGE,
            result.failureReason
        )
    }

    @Test
    fun isValid__notMatchingRegex() {
        val scoreValidator: ScoreValidator = ScoreValidatorImpl();
        val score = Score("AAA123$$$$@@!~~~", 0)

        val result: ValidationResult = scoreValidator.isValid(score)

        Assertions.assertFalse { result.isValid }
        Assertions.assertEquals(ScoreValidatorImpl.NAME_NOT_MATCHING_REGEX, result.failureReason)
    }

    @Test
    fun isValid__notMatchingRegex_2() {
        val scoreValidator: ScoreValidator = ScoreValidatorImpl();
        val score = Score("  ve ry   go   od", 0)

        val result: ValidationResult = scoreValidator.isValid(score)

        Assertions.assertFalse { result.isValid }
        Assertions.assertEquals(ScoreValidatorImpl.NAME_NOT_MATCHING_REGEX, result.failureReason)
    }

    @Test
    fun isValid__matchingRegex_1() {
        val scoreValidator: ScoreValidator = ScoreValidatorImpl();
        val score = Score("VERY GOOD", 0)

        val result: ValidationResult = scoreValidator.isValid(score)

        Assertions.assertTrue { result.isValid }
    }

    @Test
    fun isValid__matchingRegex_2() {
        val scoreValidator: ScoreValidator = ScoreValidatorImpl();
        val score = Score("VerY GOoD", 0)

        val result: ValidationResult = scoreValidator.isValid(score)

        Assertions.assertTrue { result.isValid }
    }

}
