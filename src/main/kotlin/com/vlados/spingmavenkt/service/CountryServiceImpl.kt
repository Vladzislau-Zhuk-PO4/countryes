package com.vlados.spingmavenkt.service

import com.vlados.spingmavenkt.entity.CityEntity
import com.vlados.spingmavenkt.entity.CountryEntity
import com.vlados.spingmavenkt.model.CityDto
import com.vlados.spingmavenkt.model.CountryDto
import com.vlados.spingmavenkt.repository.CityRepository
import com.vlados.spingmavenkt.repository.CountryRepository
import com.vlados.spingmavenkt.service.CountryService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.persistence.Table
import javax.transaction.Transactional

@Service
class CountryServiceImpl(
    private val countryRepository: CountryRepository,
    private val cityRepository: CityRepository,
) : CountryService {

    override fun getAll(): List<CountryDto> {
        return countryRepository.findByOrderByName()
            .map {it.toDto()}
    }

    override fun findById(id: Int): CountryDto {
        return countryRepository.findByIdOrNull(id)
            ?.toDto()
            ?: throw RuntimeException("Country not found")
    }

    @Transactional
    override fun create(dto: CountryDto): Int {
        val countryEntity = countryRepository.save(dto.toEntity())
        val cities = dto.cities.map { it.toEntity(countryEntity) }
        cityRepository.saveAll(cities)
        return  countryEntity.id
    }
    @Transactional
    override fun update(id: Int, dto: CountryDto) {
        var existingCountry = countryRepository.findByIdOrNull(id)
            ?: throw RuntimeException("Country not found")

        existingCountry.name = dto.name
        existingCountry.population = dto.population

        existingCountry = countryRepository.save(existingCountry)

        val cities = dto.cities.map { it.toEntity(existingCountry) }
        cityRepository.deleteAllByCountry(existingCountry)
        cityRepository.saveAll(cities)
    }

    @Transactional
    override fun delete(id: Int) {
        val existingCountry = countryRepository.findByIdOrNull(id)
            ?: throw RuntimeException("Country not found")
        cityRepository.deleteAllByCountry(existingCountry)
        countryRepository.deleteById(existingCountry.id)
    }

    private fun CountryEntity.toDto(): CountryDto =
        CountryDto(
            id = this.id,
            name = this.name,
            population = this.population,
            cities = this.cities.map { it.toDto() },
        )

    private fun CityEntity.toDto(): CityDto =
        CityDto(
            name = this.name,
            area = this.area,
        )

    private fun CountryDto.toEntity(): CountryEntity =
        CountryEntity(
            id = 0,
            name = this.name,
            population = this.population,
        )

    private fun CityDto.toEntity(country: CountryEntity): CityEntity =
        CityEntity(
            id = 0,
            name = this.name,
            area = this.area,
            country = country,
        )
}
