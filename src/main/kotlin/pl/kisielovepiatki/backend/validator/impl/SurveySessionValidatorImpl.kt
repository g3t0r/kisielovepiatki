package pl.kisielovepiatki.backend.validator.impl

import org.springframework.stereotype.Component
import pl.kisielovepiatki.backend.model.entity.survey.Survey
import pl.kisielovepiatki.backend.model.entity.survey.SurveySession
import pl.kisielovepiatki.backend.service.domain.SurveyService
import pl.kisielovepiatki.backend.validator.SurveySessionValidator
import pl.kisielovepiatki.backend.validator.ValidationResult

@Component
class SurveySessionValidatorImpl(
    private val surveyService: SurveyService
) : GenericValidatorImpl<SurveySession>(), SurveySessionValidator {

    companion object {
        const val INCORRECT_FOREIGN_KEY_SURVEY = "Incorrect foreign key: Survey"
    }

    override fun isValid(obj: SurveySession): ValidationResult {
        return isSurveyValid(obj.survey)
    }

    private fun isSurveyValid(survey: Survey): ValidationResult {
        if (survey.id == null || surveyService.findById(survey.id!!) == null) {
            return ValidationResult(false, INCORRECT_FOREIGN_KEY_SURVEY)
        }
        return ValidationResult(true, null)
    }
}
