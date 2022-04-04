package pl.kisielovepiatki.backend.service.domain

import pl.kisielovepiatki.backend.exception.EntityNotFoundException
import pl.kisielovepiatki.backend.exception.NotFoundExceptionUtils
import pl.kisielovepiatki.backend.model.entity.DatabaseModel
import kotlin.jvm.Throws

interface GenericEntityService<T: DatabaseModel<ID>, ID: Any> {

    fun findAll(): List<T>

    /**
     * Function tries to find entity for given id
     * @param id of type ID
     * @return entity or null
     * */
    fun findById(id: ID): T?

    /**
     * Function gets entity for given id
     * @param id of type ID
     * @return entity
     * @throws EntityNotFoundException
     * */
    @Throws(EntityNotFoundException::class)
    fun getById(id: ID): T

    @Throws(EntityNotFoundException::class)
    fun delete(id: ID)

    fun delete(entity: T)

    fun save(entity: T)
    fun saveAll(entities: Iterable<T>)
}
