package juyeong.backend.domain.github.presentation.dto

import juyeong.backend.domain.github.presentation.dto.element.CommitElement

data class QueryCommitsResponse(
    val commits: List<CommitElement>
)
