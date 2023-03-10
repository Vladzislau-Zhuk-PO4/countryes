package com.vlados.spingmavenkt.model

data class CountryDto(
    val id: Int? = null,
    val name: String,
    val population: Int,
    val cities: List<CityDto>,
)
