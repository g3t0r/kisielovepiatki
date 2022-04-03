package pl.kisielovepiatki.backend.repository

import pl.kisielovepiatki.backend.model.entity.survey.Answer
import java.time.Instant

interface AnswerRepository: GenericRepository<Answer, Int> {
    fun findAllByCreatedAt(createdAt: Instant): Set<Answer>
}
