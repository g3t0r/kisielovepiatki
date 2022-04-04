package pl.kisielovepiatki.backend.controller

import org.springframework.web.bind.annotation.*
import pl.kisielovepiatki.backend.model.entity.survey.Score
import pl.kisielovepiatki.backend.service.domain.ScoreService

@RestController
@RequestMapping("score-values")
class ScoreValuesController(
        private val scoreService: ScoreService
) {

    @GetMapping
    fun getAllScoreValues(): List<Score> {
        return scoreService.findAll();
    }

    @PostMapping
    fun saveScore(@RequestBody score: Score) {
        return scoreService.save(score)
    }
}
