package pl.kisielovepiatki.backend.model.entity.survey

import pl.kisielovepiatki.backend.model.entity.DatabaseModel
import pl.kisielovepiatki.backend.model.entity.User
import java.time.Instant
import javax.persistence.*

@Entity
class Answer(
        @JoinColumn(name = "score_id")
        @ManyToOne(fetch = FetchType.EAGER)
        var score: Score,
        @JoinColumn(name = "user_id")
        @ManyToOne(fetch = FetchType.LAZY)
        var user: User,
        @JoinColumn(name = "session_id")
        @ManyToOne(fetch = FetchType.LAZY)
        var session: SurveySession
): DatabaseModel<Int> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    override var id: Int? = null

    @Column(name = "created_at")
    var createdAt = Instant.now(); private set

    override fun toString(): String {
        return "Answer(score=$score, user=${user.id}, id=$id, createdAt=$createdAt)"
    }
}
