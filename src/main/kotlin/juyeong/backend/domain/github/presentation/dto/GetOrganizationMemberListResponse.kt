package juyeong.backend.domain.github.presentation.dto

import juyeong.backend.domain.github.presentation.dto.element.OrganizationMemberElement

data class GetOrganizationMemberListResponse(
    val members: List<OrganizationMemberElement>
)
