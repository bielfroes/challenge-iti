package com.iti.challenge.password.unit

import com.iti.challenge.password.domain.model.dto.CheckPasswordDTO
import com.iti.challenge.password.domain.service.CheckPasswordService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue


class CheckPasswordUnitTest {
    private var service: CheckPasswordService? = null

    @BeforeEach
    fun beforeEach() {
        service = CheckPasswordService()
    }

    @Test
    fun shouldReturnValidPassword() {
        val entity = CheckPasswordDTO()
        entity.password = "AbTp9!fok"
        service?.let { assertTrue(it.handle(entity)) }
    }

    @Test
    fun shouldReturnInvalidPasswordBecauseDontContainsUpperCase() {
        val entity = CheckPasswordDTO()
        entity.password = "abtp9!fok"
        service?.let { assertFalse(it.handle(entity)) }
    }

    @Test
    fun shouldReturnInvalidPasswordBecauseDontContainsLowerCase() {
        val entity = CheckPasswordDTO()
        entity.password = "ABTP9!FOK"
        service?.let { assertFalse(it.handle(entity)) }
    }

    @Test
    fun shouldReturnInvalidPasswordBecauseDontContainsSpecialCaracter() {
        val entity = CheckPasswordDTO()
        entity.password = "AbTp91fok"
        service?.let { assertFalse(it.handle(entity)) }
    }

    @Test
    fun shouldReturnInvalidPasswordBecauseDontContainsDigit() {
        val entity = CheckPasswordDTO()
        entity.password = "AbTp@!fok"
        service?.let { assertFalse(it.handle(entity)) }
    }

    @Test
    fun shouldReturnInvalidPasswordBecauseHasRepeatedCharacters() {
        val entity = CheckPasswordDTO()
        entity.password = "AbTp9!foo"
        service?.let { assertFalse(it.handle(entity)) }
    }
}