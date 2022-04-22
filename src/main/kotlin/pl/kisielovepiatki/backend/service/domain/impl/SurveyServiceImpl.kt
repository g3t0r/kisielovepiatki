package pl.kisielovepiatki.backend.service.domain.impl

import org.springframework.stereotype.Service
import pl.kisielovepiatki.backend.model.entity.survey.Survey
import pl.kisielovepiatki.backend.repository.SurveyRepository
import pl.kisielovepiatki.backend.service.domain.SurveyService
import pl.kisielovepiatki.backend.validator.EmptyValidator

@Service
class SurveyServiceImpl(
   repository: SurveyRepository,
   validator: EmptyValidator<Survey>
) : SurveyService, GenericEntityServiceImpl<Survey, Int>(
    repository, validator
)
