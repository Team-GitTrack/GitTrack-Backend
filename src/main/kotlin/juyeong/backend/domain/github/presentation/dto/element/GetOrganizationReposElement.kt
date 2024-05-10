package juyeong.backend.domain.github.presentation.dto.element

data class GetOrganizationReposElement(
    val name: String,
    val description: String,
    val isPrivate: Boolean,
)