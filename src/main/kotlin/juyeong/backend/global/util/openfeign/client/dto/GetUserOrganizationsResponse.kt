package juyeong.backend.global.util.openfeign.client.dto

data class GetUserOrganizationsResponse (
    val login: String = "",
    val avatarUrl: String = "",
    val description: String?,
)