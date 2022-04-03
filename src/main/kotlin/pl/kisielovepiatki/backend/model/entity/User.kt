package pl.kisielovepiatki.backend.model.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    var id: Int? = null;
}
