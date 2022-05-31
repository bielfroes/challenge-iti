package com.iti.challenge.password.integration

import com.fasterxml.jackson.databind.ObjectMapper
import com.iti.challenge.password.domain.model.dto.CheckPasswordDTO
import com.iti.challenge.password.infra.IntegrationTest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@IntegrationTest
internal class CheckPasswordIntegrationTest {
    private val PATH = "/api/v1/password/check"

    @Autowired
    private val mock: MockMvc? = null

    @Autowired
    private val mapper: ObjectMapper? = null
    @Test
    @Throws(Exception::class)
    fun shouldReturnOk() {
        val entity = CheckPasswordDTO()
        entity.password = "AbTp9!fok"
        mock!!.perform(
            MockMvcRequestBuilders.post(PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper!!.writeValueAsString(entity))
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    @Throws(java.lang.Exception::class)
    fun shouldReturnBadRequest() {
        val entity = CheckPasswordDTO()
        entity.password = null
        mock!!.perform(
            MockMvcRequestBuilders.post(PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper!!.writeValueAsString(entity))
        )
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
    }

}