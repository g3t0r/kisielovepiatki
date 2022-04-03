package pl.kisielovepiatki.backend.service.domain

import org.springframework.stereotype.Service
import pl.kisielovepiatki.backend.model.entity.survey.Answer
import pl.kisielovepiatki.backend.repository.AnswerRepository
import pl.kisielovepiatki.backend.service.domain.impl.GenericEntityServiceImpl
import java.time.Instant

@Service
class AnswerServiceImpl(
        private val answerRepository: AnswerRepository
) : AnswerService, GenericEntityServiceImpl<Answer, Int>(
        answerRepository
) {
    override fun findAnswerByCreatedAt(createdAt: Instant): Set<Answer> {
        return answerRepository.findAllByCreatedAt(Instant.now());
    }
}
