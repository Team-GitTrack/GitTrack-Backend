package juyeong.backend.domain.github.presentation.dto

data class GetOrganizationMemberListResponse(
    val members: List<OrganizationMemberElement>
)
