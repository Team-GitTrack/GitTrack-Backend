package juyeong.backend.domain.github.presentation.dto

data class GetIssueListResponse(
    val issues: List<IssueElement>
)
