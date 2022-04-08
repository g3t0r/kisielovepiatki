package pl.kisielovepiatki.backend.service.domain.impl

import org.springframework.data.repository.NoRepositoryBean
import org.springframework.transaction.annotation.Transactional
import pl.kisielovepiatki.backend.exception.EntityNotFoundException
import pl.kisielovepiatki.backend.model.entity.DatabaseModel
import pl.kisielovepiatki.backend.repository.GenericRepository
import pl.kisielovepiatki.backend.service.domain.GenericEntityService
import pl.kisielovepiatki.backend.validator.GenericValidator

@NoRepositoryBean
open class GenericEntityServiceImpl<T : DatabaseModel<ID>, ID : Any>(
    private val genericRepository: GenericRepository<T, ID>,
    private val genericValidator: GenericValidator<T>
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
        genericValidator.ifValid(entity) {genericRepository.save(entity) }
    }

    @Transactional
    override fun saveAll(entities: Iterable<T>) {
        entities.forEach {entity ->
            genericValidator.ifValid(entity) {genericRepository.save(entity)}
        }
    }

    override fun update(entity: T) {
        genericValidator.ifValid(entity) {genericRepository.save(entity) }
    }
}
