package pl.kisielovepiatki.backend.model.entity.survey

import pl.kisielovepiatki.backend.model.entity.DatabaseModel
import java.time.Instant
import javax.persistence.*

@Entity
class SurveySession (
    var startTime: Instant,
    var endTime: Instant,
    @ManyToOne
    @JoinColumn(name = "survey_id")
    var survey: Survey
): DatabaseModel<Int> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override var id: Int? = null;

    @OneToMany(mappedBy = "session")
    var answers: Set<Answer> = setOf();
}
