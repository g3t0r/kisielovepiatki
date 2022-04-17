package pl.kisielovepiatki.backend.validator.impl

import org.springframework.stereotype.Component
import pl.kisielovepiatki.backend.model.entity.Kissel
import pl.kisielovepiatki.backend.model.entity.User
import pl.kisielovepiatki.backend.model.entity.survey.Answer
import pl.kisielovepiatki.backend.model.entity.survey.Score
import pl.kisielovepiatki.backend.model.entity.survey.SurveySession
import pl.kisielovepiatki.backend.service.domain.KisselService
import pl.kisielovepiatki.backend.service.domain.UserService
import pl.kisielovepiatki.backend.service.domain.ScoreService
import pl.kisielovepiatki.backend.service.domain.SessionService
import pl.kisielovepiatki.backend.utils.Validation
import pl.kisielovepiatki.backend.utils.ValidationUtils
import pl.kisielovepiatki.backend.validator.AnswerValidator
import pl.kisielovepiatki.backend.validator.ValidationResult

@Component
class AnswerValidatorImpl(
    private val scoreService: ScoreService,
    private val userService: UserService,
    private val sessionService: SessionService,
    private val kisselService: KisselService
) : AnswerValidator, GenericValidatorImpl<Answer>() {

    companion object {
        const val INCORRECT_FOREIGN_KEY_KISSEL = "Incorrect foreign key: Kissel"
        const val INCORRECT_FOREIGN_KEY_SCORE = "Incorrect foreign key: Score"
        const val INCORRECT_FOREIGN_KEY_USER = "Incorrect foreign key: User"
        const val INCORRECT_FOREIGN_KEY_SESSION = "Incorrect foreign key: Session"
    }

    override fun isValid(obj: Answer): ValidationResult {
        val list = listOf<Validation>(
            {isKisselForeignKeyValid(obj.kissel)},
            {isScoreForeignKeyValid(obj.score)},
            {isUserForeignKeyValid(obj.user)},
            {isSessionForeignKeyValid(obj.session)}
        )

        return ValidationUtils.validateAll(list)
    }

    private fun isKisselForeignKeyValid(kissel: Kissel): ValidationResult {
        if(kissel.id == null || kisselService.findById(kissel.id!!) == null) {
            return ValidationResult(false, INCORRECT_FOREIGN_KEY_KISSEL)
        }
        return ValidationResult(true, null)
    }

    private fun isScoreForeignKeyValid(score: Score): ValidationResult {
        if(score.id == null || scoreService.findById(score.id!!) == null) {
            return ValidationResult(false, INCORRECT_FOREIGN_KEY_SCORE)
        }
        return ValidationResult(true, null)
    }

    private fun isUserForeignKeyValid(user: User): ValidationResult {
        if(user.id == null || userService.findById(user.id!!) == null) {
            return ValidationResult(false, INCORRECT_FOREIGN_KEY_USER)
        }
        return ValidationResult(true, null)
    }

    private fun isSessionForeignKeyValid(session: SurveySession): ValidationResult {
        if(session.id == null || sessionService.findById(session.id!!) == null) {
            return ValidationResult(false, INCORRECT_FOREIGN_KEY_SESSION)
        }
        return ValidationResult(true, null)
    }

}
