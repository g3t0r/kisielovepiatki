package pl.kisielovepiatki.backend.model.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Kissel(
        var company: String,
        var name: String,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    var id: Int? = null;
}
