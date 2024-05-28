package juyeong.backend.domain.github.presentation.dto

import juyeong.backend.domain.github.presentation.dto.element.CommitElement
import juyeong.backend.domain.github.presentation.dto.element.IssueElement

data class QueryCommitsResponse(
    val commits: List<CommitElement>
)
