package juyeong.backend.domain.github.presentation.dto.element

data class CommitCountElement(
    val login: String,
    val month: Int,
    val value: Int
)