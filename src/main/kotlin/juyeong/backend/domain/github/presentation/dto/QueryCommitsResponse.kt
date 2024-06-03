package juyeong.backend.domain.github.presentation.dto

import juyeong.backend.domain.github.presentation.dto.element.CommitCountElement

data class QueryCommitsResponse(
    val commits: List<CommitCountElement>
)
