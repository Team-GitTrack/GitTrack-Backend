package juyeong.backend.global.util.openfeign.client.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class TokenResponse (
    val accessToken: String?,
)