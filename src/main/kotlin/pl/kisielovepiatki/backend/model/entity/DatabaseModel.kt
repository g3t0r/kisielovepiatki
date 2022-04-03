package pl.kisielovepiatki.backend.model.entity

interface DatabaseModel<ID: Any> {
    val id: ID?
}
