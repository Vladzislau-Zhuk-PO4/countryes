package com.vlados.spingmavenkt.repository

import com.vlados.spingmavenkt.entity.CityEntity
import com.vlados.spingmavenkt.entity.CountryEntity
import org.springframework.data.repository.CrudRepository

interface CityRepository:CrudRepository<CityEntity, Int> {

    fun deleteAllByCountry(country: CountryEntity)
}