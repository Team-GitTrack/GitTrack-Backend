package juyeong.backend.domain.github.presentation.dto

import juyeong.backend.domain.github.presentation.dto.element.GetOrganizationReposElement

data class GetOrganizationRepoListResponse(
    val repos: List<GetOrganizationReposElement>
)
