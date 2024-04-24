package juyeong.backend.domain.github.presentation.dto

data class GetOrganizationReposElement(
    val name: String,
    val description: String,
    val isPrivate: Boolean,
)