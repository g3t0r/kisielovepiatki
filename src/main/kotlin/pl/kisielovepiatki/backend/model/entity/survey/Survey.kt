package pl.kisielovepiatki.backend.model.entity.survey

import javax.persistence.*

@Entity
class Survey(
        var text: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    var id: Int? = null;

    @OneToMany(mappedBy = "survey", fetch = FetchType.LAZY)
    var sessions: Set<SurveySession> = setOf();
}
