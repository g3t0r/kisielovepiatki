package pl.kisielovepiatki.backend.validator.impl

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import pl.kisielovepiatki.backend.model.entity.User
import pl.kisielovepiatki.backend.model.entity.survey.Answer
import pl.kisielovepiatki.backend.model.entity.survey.Score
import pl.kisielovepiatki.backend.model.entity.survey.Survey
import pl.kisielovepiatki.backend.model.entity.survey.SurveySession
import pl.kisielovepiatki.backend.service.domain.ScoreService
import pl.kisielovepiatki.backend.service.domain.SessionService
import pl.kisielovepiatki.backend.service.domain.UserService
import java.time.Instant
import java.time.temporal.ChronoUnit

internal class AnswerValidatorImplTest {

    private var userService: UserService = Mockito.spy(UserService::class.java)
    private var scoreService: ScoreService = Mockito.spy(ScoreService::class.java)
    private var sessionService: SessionService = Mockito.spy(SessionService::class.java)
    private val answerValidator = AnswerValidatorImpl(scoreService, userService, sessionService)

    private val goodScore = Score("good", 0).apply { id = 0 }
    private val badScore = Score("bad", 1).apply { id = 1 }
    private val nullIdScore = Score("nullId", 0).apply { id = null }

    private val goodUser = User().apply { id = 0 }
    private val badUser = User().apply { id = 1 }
    private val nullIdUser = User().apply { id = null }

    private val start = Instant.now()
    private val end = start.plus(3, ChronoUnit.MINUTES)
    private val session =
        SurveySession(start, end, Survey("")).apply { id = 0 }

    private val badSession =
        SurveySession(start, end, Survey("")).apply { id = 1 }

    private val nullIdSession =
        SurveySession(start, end, Survey("")).apply { id = null }

    init {
        Mockito.`when`(userService.findById(0)).thenReturn(User())
        Mockito.`when`(scoreService.findById(0)).thenReturn(Score("", 0))
        Mockito.`when`(sessionService.findById(0))
            .thenReturn(SurveySession(start, end, Survey("")))


        Mockito.`when`(userService.findById(1)).thenReturn(null)
        Mockito.`when`(scoreService.findById(1)).thenReturn(null)
        Mockito.`when`(sessionService.findById(1)).thenReturn(null)

    }

    @Test
    fun isValid__emptyUserId() {
        val answer = Answer(goodScore, nullIdUser, session)
        val result = answerValidator.isValid(answer)

        Assertions.assertFalse(result.isValid)
        Assertions.assertEquals(
            AnswerValidatorImpl.INCORRECT_FOREIGN_KEY_USER,
            result.failureReason
        )
    }

    @Test
    fun isValid__userNotFound() {
        val answer = Answer(goodScore, badUser, session)
        val result = answerValidator.isValid(answer)

        Assertions.assertFalse(result.isValid)
        Assertions.assertEquals(
            AnswerValidatorImpl.INCORRECT_FOREIGN_KEY_USER,
            result.failureReason
        )
    }

    @Test
    fun isValid__emptyScoreId() {
        val answer = Answer(nullIdScore, goodUser, session)
        val result = answerValidator.isValid(answer)

        Assertions.assertFalse(result.isValid)
        Assertions.assertEquals(
            AnswerValidatorImpl.INCORRECT_FOREIGN_KEY_SCORE,
            result.failureReason
        )
    }

    @Test
    fun isValid__incorrectScoreId() {
        val answer = Answer(badScore, goodUser, session)
        val result = answerValidator.isValid(answer)

        Assertions.assertFalse(result.isValid)
        Assertions.assertEquals(
            AnswerValidatorImpl.INCORRECT_FOREIGN_KEY_SCORE,
            result.failureReason
        )
    }

    @Test
    fun isValid__emptySessionId() {
        val answer = Answer(goodScore, goodUser, nullIdSession)
        val result = answerValidator.isValid(answer)

        Assertions.assertFalse(result.isValid)
        Assertions.assertEquals(
            AnswerValidatorImpl.INCORRECT_FOREIGN_KEY_SESSION,
            result.failureReason
        )
    }

    @Test
    fun isValid__badSessionId() {
        val answer = Answer(goodScore, goodUser, badSession)
        val result = answerValidator.isValid(answer)

        Assertions.assertFalse(result.isValid)
        Assertions.assertEquals(
            AnswerValidatorImpl.INCORRECT_FOREIGN_KEY_SESSION,
            result.failureReason
        )
    }

    @Test
    fun isValid__allGood() {
        val answer = Answer(goodScore, goodUser, session)
        val result = answerValidator.isValid(answer)

        Assertions.assertTrue(result.isValid)
        Assertions.assertNull(result.failureReason)
    }

}
