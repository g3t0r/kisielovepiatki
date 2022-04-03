package pl.kisielovepiatki.backend.model.entity.survey

import pl.kisielovepiatki.backend.model.entity.DatabaseModel
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Score (
        var name: String,
        var value: Int
): DatabaseModel<Int> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override var id: Int? = null;
}
