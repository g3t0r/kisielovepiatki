package pl.kisielovepiatki.backend.service.domain.impl

import org.springframework.data.repository.NoRepositoryBean
import pl.kisielovepiatki.backend.model.entity.DatabaseModel
import pl.kisielovepiatki.backend.repository.GenericRepository
import pl.kisielovepiatki.backend.service.domain.GenericEntityService

@NoRepositoryBean
open class GenericEntityServiceImpl<T : DatabaseModel<ID>, ID : Any>(
        val genericRepository: GenericRepository<T, ID>
) : GenericEntityService<T, ID> {
    override fun findById(id: ID): T? {
        return genericRepository
                .findById(id)
                .orElse(null);
    }

    override fun getById(id: ID): T {
        return genericRepository
                .findById(id)
                .orElseThrow()
    }

    override fun delete(id: ID) {
        TODO("Not yet implemented")
    }

    override fun delete(entity: T) {
        TODO("Not yet implemented")
    }
}
