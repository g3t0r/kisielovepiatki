package pl.kisielovepiatki.backend.service.domain.impl

import org.springframework.stereotype.Service
import pl.kisielovepiatki.backend.model.entity.survey.Score
import pl.kisielovepiatki.backend.repository.ScoreRepository
import pl.kisielovepiatki.backend.service.domain.ScoreService

@Service
class ScoreServiceImpl(
        private val scoreRepository: ScoreRepository
) : ScoreService, GenericEntityServiceImpl<Score, Int>(
        scoreRepository
)
