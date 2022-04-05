package pl.kisielovepiatki.backend.validator

/**
 * @property isValid boolean value telling if validation vas successful
 * @property failureReason optional message pointing reason of failure
 *  */
data class ValidationResult(
        val isValid: Boolean,
        val failureReason: String?
)
