package juyeong.backend.domain.github.presentation.dto

data class IssueElement(
    val fullName: String,
    val title: String,
    val number: Int,
)