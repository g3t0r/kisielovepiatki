package pl.kisielovepiatki.backend.validator.impl

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import pl.kisielovepiatki.backend.model.entity.Kissel
import pl.kisielovepiatki.backend.validator.KisselValidator

internal class KisselValidatorImplTest {

    @Test
    fun isValid__emptyName() {
        val kisselValidator: KisselValidator = KisselValidatorImpl()
        val kissel = Kissel("", "")

        val result = kisselValidator.isValid(kissel)

        Assertions.assertFalse {result.isValid}
        Assertions.assertEquals(KisselValidatorImpl.EMPTY_NAME_NOT_ALLOWED, result.failureReason)
    }

    @Test
    fun isValid__blankName() {
        val kisselValidator: KisselValidator = KisselValidatorImpl()
        val kissel = Kissel("", "    ")

        val result = kisselValidator.isValid(kissel)

        Assertions.assertFalse {result.isValid}
        Assertions.assertEquals(KisselValidatorImpl.BLANK_NAME_NOT_ALLOWED, result.failureReason)
    }

    @Test
    fun isValid__correctName() {
        val kisselValidator: KisselValidator = KisselValidatorImpl()
        val kissel = Kissel("", "some name")

        val result = kisselValidator.isValid(kissel)

        Assertions.assertTrue {result.isValid}
    }

    @Test
    fun isValid__correctCompanyEmpty() {
        val kisselValidator: KisselValidator = KisselValidatorImpl()
        val kissel = Kissel("", "some name")

        val result = kisselValidator.isValid(kissel)

        Assertions.assertTrue {result.isValid}
    }

    @Test
    fun isValid__correctCompanyBlankNotEmpty() {
        val kisselValidator: KisselValidator = KisselValidatorImpl()
        val kissel = Kissel("     ", "some name")

        val result = kisselValidator.isValid(kissel)

        Assertions.assertFalse {result.isValid}
        Assertions.assertEquals(KisselValidatorImpl.COMPANY_MUST_BE_EMPTY_IF_BLANK, result.failureReason)
    }
}
