package com.vlados.spingmavenkt.entity

import javax.persistence.*

@Entity
@Table(name = "city")
class CityEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    val id: Int = 0,
    var name: String = "",
    var area: String = "",
    @ManyToOne
    @JoinColumn(name ="country_id")
    var country: CountryEntity,
)