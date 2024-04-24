package juyeong.backend.domain.github.presentation.dto

data class GetOrganizationRepoListResponse(
    val repos: List<GetOrganizationReposElement>
)
