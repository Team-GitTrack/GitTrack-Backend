package juyeong.backend.domain.github.presentation.dto

data class GetOrganizationListResponse(
    val organizations: List<OrganizationListElement>
)
