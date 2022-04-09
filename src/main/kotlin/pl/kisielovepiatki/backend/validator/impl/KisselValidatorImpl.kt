package pl.kisielovepiatki.backend.validator.impl

import org.springframework.stereotype.Component
import pl.kisielovepiatki.backend.model.entity.Kissel
import pl.kisielovepiatki.backend.validator.KisselValidator
import pl.kisielovepiatki.backend.validator.ValidationResult

@Component
class KisselValidatorImpl : KisselValidator, GenericValidatorImpl<Kissel>() {
    companion object {
        const val EMPTY_NAME_NOT_ALLOWED = "Name can't be empty"
        const val BLANK_NAME_NOT_ALLOWED = "Name can't be blank"
        const val COMPANY_MUST_BE_EMPTY_IF_BLANK = "Company can't be blank if it's not empty"
    }

    override fun isValid(obj: Kissel): ValidationResult {
        val nameValidationResult = isNameValid(obj.name)

        if(!nameValidationResult.isValid) {
            return nameValidationResult;
        }

        val companyValidationResult = isCompanyValid(obj.company)

        if(!companyValidationResult.isValid) {
            return companyValidationResult;
        }

        return ValidationResult(true, null)
    }

    private fun isNameValid(name: String): ValidationResult {
       if(name.isEmpty()) {
           return ValidationResult(false, EMPTY_NAME_NOT_ALLOWED)
       }

        if(name.isBlank()) {
            return ValidationResult(false, BLANK_NAME_NOT_ALLOWED)
        }

        return ValidationResult(true, null)
    }

    private fun isCompanyValid(company: String): ValidationResult {
        if(company.isNotEmpty() && company.isBlank()) {
            return ValidationResult(false, COMPANY_MUST_BE_EMPTY_IF_BLANK)
        }
        return ValidationResult(true, null)
    }
}
