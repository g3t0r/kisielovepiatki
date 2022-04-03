package pl.kisielovepiatki.backend.service.domain

import pl.kisielovepiatki.backend.model.entity.survey.Answer
import java.time.Instant

interface AnswerService {
    fun findAnswerByCreatedAt(createdAt: Instant): Set<Answer>
}
