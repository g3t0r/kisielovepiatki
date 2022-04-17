package pl.kisielovepiatki.backend.validator.impl

import org.springframework.stereotype.Component
import pl.kisielovepiatki.backend.model.entity.User
import pl.kisielovepiatki.backend.validator.ValidationResult

@Component
class UserValidatorImpl: GenericValidatorImpl<User>() {
    override fun isValid(obj: User): ValidationResult {
        TODO("Not yet implemented")
    }
}
