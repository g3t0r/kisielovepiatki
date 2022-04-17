package pl.kisielovepiatki.backend.repository

import pl.kisielovepiatki.backend.model.entity.User

interface UserRepository : GenericRepository<User, Int>
