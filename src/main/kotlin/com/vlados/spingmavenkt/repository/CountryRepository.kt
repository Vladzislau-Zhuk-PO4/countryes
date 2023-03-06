package com.vlados.spingmavenkt.repository

import com.vlados.spingmavenkt.entity.CountryEntity
import org.springframework.data.repository.CrudRepository

interface CountryRepository: CrudRepository<CountryEntity, Int> {

    fun findByOrderByName(): List<CountryEntity>
}