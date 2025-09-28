package com.suman.financialapi.dto
import com.fasterxml.jackson.annotation.JsonProperty


data class DealState(
    @JsonProperty("state")
    val state : Status,

    @JsonProperty("comments")
    val comments : String,

    @JsonProperty("version")
    val version : Int
)