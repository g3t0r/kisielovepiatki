package pl.kisielovepiatki.backend.model.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Kissel(
        var company: String,
        var name: String,
): DatabaseModel<Int> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override var id: Int? = null;
}
