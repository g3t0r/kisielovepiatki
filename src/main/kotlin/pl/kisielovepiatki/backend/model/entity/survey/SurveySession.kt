package pl.kisielovepiatki.backend.model.entity.survey

import java.time.Instant
import javax.persistence.*

@Entity
class SurveySession (
    var startTime: Instant,
    var endTime: Instant,
    @ManyToOne
    @Column(name = "survey")
    var survey: Survey
) {
    @Id
    @GeneratedValue
    var id: Int? = null;

    @OneToMany(mappedBy = "session")
    var answers: Set<Answer> = setOf();
}
