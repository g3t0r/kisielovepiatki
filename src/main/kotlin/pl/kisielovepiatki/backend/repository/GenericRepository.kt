package pl.kisielovepiatki.backend.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface GenericRepository<T, ID>: JpaRepository<T, ID> {
}
