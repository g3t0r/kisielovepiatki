package pl.kisielovepiatki.backend.service.domain.impl

import org.springframework.stereotype.Service
import pl.kisielovepiatki.backend.model.entity.survey.SurveySession
import pl.kisielovepiatki.backend.repository.SessionRepository
import pl.kisielovepiatki.backend.service.domain.SessionService
import pl.kisielovepiatki.backend.validator.SurveySessionValidator

@Service
class SessionServiceImpl(
    repository: SessionRepository,
    validator: SurveySessionValidator
) : SessionService, GenericEntityServiceImpl<SurveySession, Int>(
    repository,
    validator
)
