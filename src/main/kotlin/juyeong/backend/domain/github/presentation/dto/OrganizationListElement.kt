package juyeong.backend.domain.github.presentation.dto

data class OrganizationListElement(
    val login: String = "",
    val avatarUrl: String = "",
    val description: String = "",
)