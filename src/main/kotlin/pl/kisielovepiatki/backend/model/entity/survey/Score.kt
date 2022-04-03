package pl.kisielovepiatki.backend.model.entity.survey

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Score (
        var name: String,
        var value: Int
) {
    @Id
    @GeneratedValue
    var id: Int? = null;
}
