package com.iti.challenge.password.adapter

import com.iti.challenge.password.domain.model.dto.CheckPasswordDTO
import com.iti.challenge.password.domain.usecase.CheckPasswordUseCase
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/password")
class PasswordController(val service: CheckPasswordUseCase) {

    @PostMapping("/check")
    fun check(@Validated @RequestBody command: CheckPasswordDTO): ResponseEntity<Boolean?>? = ResponseEntity.ok().body(service.handle(command))

}