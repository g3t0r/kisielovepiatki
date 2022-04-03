package pl.kisielovepiatki.backend.model.entity.survey

import pl.kisielovepiatki.backend.model.entity.User
import java.time.Instant
import javax.persistence.*

@Entity
class Answer(
        @Column(name = "score_id")
        @ManyToOne(fetch = FetchType.EAGER)
        var score: Score,
        @Column(name = "user_id")
        @ManyToOne(fetch = FetchType.LAZY)
        var user: User,
        @Column(name = "session_id")
        @ManyToOne(fetch = FetchType.LAZY)
        var session: SurveySession
) {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name ="id")
    var id: Int? = null

    @Column(name = "created_at")
    var createdAt = Instant.now(); private set

    override fun toString(): String {
        return "Answer(score=$score, user=${user.id}, id=$id, createdAt=$createdAt)"
    }
}
