package juyeong.backend.domain.github.presentation.dto

import juyeong.backend.domain.github.presentation.dto.element.IssueElement

data class GetIssueListResponse(
    val issues: List<IssueElement>
)
