package pl.kisielovepiatki.backend.model.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
class User: DatabaseModel<Int> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override var id: Int? = null;
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id ?: 0
    }


}
