package juyeong.backend.domain.github.presentation.dto

import juyeong.backend.domain.github.presentation.dto.element.CommitElement

data class QueryCommitsResponse(
    val commits: List<Commit>
)

data class Commit(
    val login: String,
    val commits: List<CommitElement>
)
