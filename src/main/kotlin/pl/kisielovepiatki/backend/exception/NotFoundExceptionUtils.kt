package pl.kisielovepiatki.backend.exception

abstract class NotFoundExceptionUtils {

    companion object {
        fun toMessage(fieldName: String, fieldValue: Any?): String {
            return "Can't find entity of class identified with $fieldName=$fieldValue"
        }
    }
}
