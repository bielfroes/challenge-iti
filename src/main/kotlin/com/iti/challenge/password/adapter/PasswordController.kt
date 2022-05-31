package com.iti.challenge.password.adapter

import com.iti.challenge.password.domain.model.dto.CheckPasswordDTO
import com.iti.challenge.password.domain.usecase.CheckPasswordUseCase
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/api/v1/password"], produces = [MediaType.APPLICATION_JSON_VALUE])
class PasswordController(val service: CheckPasswordUseCase) {

    @PostMapping(path = ["/check"], consumes = [APPLICATION_JSON_VALUE])
    fun check(@Validated @RequestBody command: CheckPasswordDTO): ResponseEntity<Boolean?>? {
        val valid = service.handle(command)
        return ResponseEntity.ok().body(valid)
    }

}