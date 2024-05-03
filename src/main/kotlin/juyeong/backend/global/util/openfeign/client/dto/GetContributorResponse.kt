package juyeong.backend.global.util.openfeign.client.dto

data class GetContributorResponse(
    val login: String,
    val contributions: Int
)
