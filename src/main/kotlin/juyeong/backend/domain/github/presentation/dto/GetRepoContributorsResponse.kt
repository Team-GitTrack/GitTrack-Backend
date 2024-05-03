package juyeong.backend.domain.github.presentation.dto

import juyeong.backend.global.util.openfeign.client.dto.GetContributorResponse

data class GetRepoContributorsResponse(
    val contributors: List<GetContributorResponse>
)