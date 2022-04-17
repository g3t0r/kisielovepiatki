package pl.kisielovepiatki.backend.service.domain.impl

import org.springframework.stereotype.Component
import pl.kisielovepiatki.backend.model.entity.User
import pl.kisielovepiatki.backend.repository.UserRepository
import pl.kisielovepiatki.backend.service.domain.UserService
import pl.kisielovepiatki.backend.validator.impl.UserValidatorImpl

@Component
class UserServiceImpl(
    userRepository: UserRepository,
    userValidator: UserValidatorImpl
) : UserService,
    GenericEntityServiceImpl<User, Int>(userRepository, userValidator)
