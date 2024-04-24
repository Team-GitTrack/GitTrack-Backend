package juyeong.backend.global.util.openfeign.client.dto

data class GetOrganizationReposResponse (
    val name: String,
    val description: String? = "",
    val private: Boolean,
)