package pl.kisielovepiatki.backend.validator.impl

import org.springframework.stereotype.Component
import pl.kisielovepiatki.backend.model.entity.survey.SurveySession
import pl.kisielovepiatki.backend.validator.SurveySessionValidator
import pl.kisielovepiatki.backend.validator.ValidationResult

@Component
class SurveySessionValidatorImpl : GenericValidatorImpl<SurveySession>(), SurveySessionValidator {
    override fun isValid(obj: SurveySession): ValidationResult {
        TODO("Not yet implemented")
    }
}
