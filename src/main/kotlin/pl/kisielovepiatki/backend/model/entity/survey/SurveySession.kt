package pl.kisielovepiatki.backend.model.entity.survey

import java.time.Instant
import javax.persistence.*

@Entity
class SurveySession (
    var startTime: Instant,
    var endTime: Instant,
    @ManyToOne
    @JoinColumn(name = "survey_id")
    var survey: Survey
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null;

    @OneToMany(mappedBy = "session")
    var answers: Set<Answer> = setOf();
}
