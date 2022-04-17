package pl.kisielovepiatki.backend.validator.impl

import org.springframework.stereotype.Component
import pl.kisielovepiatki.backend.model.entity.User
import pl.kisielovepiatki.backend.model.entity.survey.Answer
import pl.kisielovepiatki.backend.model.entity.survey.Score
import pl.kisielovepiatki.backend.model.entity.survey.SurveySession
import pl.kisielovepiatki.backend.service.domain.UserService
import pl.kisielovepiatki.backend.service.domain.ScoreService
import pl.kisielovepiatki.backend.service.domain.SessionService
import pl.kisielovepiatki.backend.validator.AnswerValidator
import pl.kisielovepiatki.backend.validator.ValidationResult

@Component
class AnswerValidatorImpl(
    private val scoreService: ScoreService,
    private val userService: UserService,
    private val sessionService: SessionService
) : AnswerValidator, GenericValidatorImpl<Answer>() {

    companion object {
        const val INCORRECT_FOREIGN_KEY_SCORE = "Incorrect foreign key: Score"
        const val INCORRECT_FOREIGN_KEY_USER = "Incorrect foreign key: User"
        const val INCORRECT_FOREIGN_KEY_SESSION = "Incorrect foreign key: Session"
    }

    override fun isValid(obj: Answer): ValidationResult {
        val list = listOf<Validation>(
            {isScoreForeignKeyValid(obj.score)},
            {isUserForeignKeyValid(obj.user)},
            {isSessionForeignKeyValid(obj.session)}
        )

        val iterator = list.listIterator()
        var result = ValidationResult(true, null)

        while (iterator.hasNext() && result.isValid) {
           result = iterator.next().invoke(Unit)
        }

        return result;
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

typealias Validation = (Unit) -> ValidationResult
