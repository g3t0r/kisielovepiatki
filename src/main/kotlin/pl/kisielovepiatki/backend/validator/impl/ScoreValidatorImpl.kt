package pl.kisielovepiatki.backend.validator.impl

import org.springframework.stereotype.Component
import pl.kisielovepiatki.backend.model.entity.survey.Score
import pl.kisielovepiatki.backend.validator.ScoreValidator
import pl.kisielovepiatki.backend.validator.ValidationResult

@Component
class ScoreValidatorImpl : ScoreValidator, GenericValidatorImpl<Score>() {

    companion object {
        const val BLANK_NAME_NOT_ALLOWED_MESSAGE: String = "Name can't be blank"
        const val EMPTY_NAME_NOT_ALLOWED_MESSAGE: String = "Name can't be empty"
        const val NAME_NOT_MATCHING_REGEX: String = "Name can contain only letters and spaces"
    }

    override fun isValid(obj: Score): ValidationResult {
        return isNameValid(obj.name)
    }

    private fun isNameValid(name: String): ValidationResult {
        if (name.isEmpty()) {
            return ValidationResult(false, EMPTY_NAME_NOT_ALLOWED_MESSAGE)
        }

        if (name.isBlank()) {
            return ValidationResult(false, BLANK_NAME_NOT_ALLOWED_MESSAGE)
        }

        if (!Regex("[A-Za-z]+(\\s[A-Za-z]+)*").matches(name)) {
            return ValidationResult(false, NAME_NOT_MATCHING_REGEX)
        }

        return ValidationResult(true, null)
    }

}
