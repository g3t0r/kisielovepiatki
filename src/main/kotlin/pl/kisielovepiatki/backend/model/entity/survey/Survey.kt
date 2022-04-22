package pl.kisielovepiatki.backend.model.entity.survey

import pl.kisielovepiatki.backend.model.entity.DatabaseModel
import javax.persistence.*

@Entity
class Survey(
        var text: String
): DatabaseModel<Int> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override var id: Int? = null;

    @OneToMany(mappedBy = "survey", fetch = FetchType.LAZY)
    var sessions: Set<SurveySession> = setOf();
}
