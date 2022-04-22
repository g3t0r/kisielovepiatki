package pl.kisielovepiatki.backend.validator.impl

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import pl.kisielovepiatki.backend.model.entity.survey.Survey
import pl.kisielovepiatki.backend.model.entity.survey.SurveySession
import pl.kisielovepiatki.backend.service.domain.SurveyService
import java.time.Instant

internal class SurveySessionValidatorImplTest {

    private val emptyIdSurvey = Survey("empty").apply { id = null }
    private val goodSurvey = Survey("good").apply { id = 0 }
    private val badSurvey = Survey("bad").apply { id = 1 }

    private val surveyService = Mockito.mock(SurveyService::class.java)

    init {
        Mockito.`when`(surveyService.findById(0)).thenReturn(goodSurvey)
        Mockito.`when`(surveyService.findById(1)).thenReturn(null)
    }

    @Test
    fun isValid__emptySurveyId() {
        val session = SurveySession(Instant.now(), Instant.now(), emptyIdSurvey)
        val validator = SurveySessionValidatorImpl(surveyService)

        val result = validator.isValid(session)

        Assertions.assertFalse(result.isValid)
        Assertions.assertEquals(
            SurveySessionValidatorImpl.INCORRECT_FOREIGN_KEY_SURVEY,
            result.failureReason
        )
    }


    @Test
    fun isValid__badSession() {
        val session = SurveySession(Instant.now(), Instant.now(), badSurvey)
        val validator = SurveySessionValidatorImpl(surveyService)

        val result = validator.isValid(session)

        Assertions.assertFalse(result.isValid)
        Assertions.assertEquals(
            SurveySessionValidatorImpl.INCORRECT_FOREIGN_KEY_SURVEY,
            result.failureReason
        )
    }

    @Test
    fun isValid__allGood() {
        val session = SurveySession(Instant.now(), Instant.now(), goodSurvey)
        val validator = SurveySessionValidatorImpl(surveyService)

        val result = validator.isValid(session)

        Assertions.assertTrue(result.isValid)
        Assertions.assertNull(result.failureReason)
    }
}
