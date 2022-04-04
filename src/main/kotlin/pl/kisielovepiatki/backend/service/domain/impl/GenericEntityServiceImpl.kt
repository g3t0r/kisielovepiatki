package pl.kisielovepiatki.backend.service.domain.impl

import org.springframework.data.repository.NoRepositoryBean
import pl.kisielovepiatki.backend.exception.EntityNotFoundException
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
                .orElseThrow { EntityNotFoundException(id) }
    }

    override fun delete(id: ID) {
        val toDelete = getById(id)
        genericRepository.delete(toDelete)
    }

    override fun delete(entity: T) {
        genericRepository.delete(entity)
    }

    override fun findAll(): List<T> {
        return genericRepository.findAll();
    }

    override fun save(entity: T) {
        genericRepository.save(entity)
    }

    override fun saveAll(entities: Iterable<T>) {
        genericRepository.saveAll(entities)
    }
}
