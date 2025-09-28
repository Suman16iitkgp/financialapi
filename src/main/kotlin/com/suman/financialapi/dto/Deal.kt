package com.suman.financialapi.dto
import com.fasterxml.jackson.annotation.JsonProperty

import jakarta.persistence.*
import com.suman.financialapi.dto.Status

@Entity(name = "deals")
 data class Deal(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("dealId")
    val dealId: Long?,

    @JsonProperty("dealName")
    val dealName: String,

    @JsonProperty("status")
    val status: Status,

    @JsonProperty("version")
    val version: Int,

    @JsonProperty("comments")
    val comments: String

) 

