package com.vlados.spingmavenkt.service

import com.vlados.spingmavenkt.model.CountryDto

interface CountryService {

    fun getAll(): List<CountryDto>

    fun findById(id: Int): CountryDto

    fun create(dto: CountryDto): Int

    fun update(id: Int, dto: CountryDto)

    fun delete(id: Int)
}