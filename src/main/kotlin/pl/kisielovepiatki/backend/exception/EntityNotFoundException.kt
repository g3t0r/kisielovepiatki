package pl.kisielovepiatki.backend.exception

class EntityNotFoundException(fieldName: String, fieldValue: Any?)
    : RuntimeException(NotFoundExceptionUtils.toMessage(fieldName, fieldValue)) {
    constructor(id: Any?) : this("id", id)
}
