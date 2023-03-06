package com.vlados.spingmavenkt.controller

import com.vlados.spingmavenkt.model.CountryDto
import com.vlados.spingmavenkt.service.CountryService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/countries")
@Api(description = "Иллюстрация работы Swagger")
class CountryController(
    private val countryService: CountryService
) {

    @GetMapping
    @ApiOperation("Получение всех значений")
    fun getAll(): List<CountryDto> = countryService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Int): CountryDto =
        countryService.findById(id)

    @PostMapping
    fun create(@RequestBody dto: CountryDto): Int {
        return countryService.create(dto)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody dto: CountryDto) {
        countryService.update(id, dto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) {
        countryService.delete(id)
    }
}