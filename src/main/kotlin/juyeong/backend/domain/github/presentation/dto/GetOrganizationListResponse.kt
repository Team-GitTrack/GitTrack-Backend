package juyeong.backend.domain.github.presentation.dto

import juyeong.backend.domain.github.presentation.dto.element.OrganizationElement

data class GetOrganizationListResponse(
    val organizations: List<OrganizationElement>
)
