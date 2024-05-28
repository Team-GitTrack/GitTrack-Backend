package juyeong.backend.global.util.openfeign.client.dto

import java.time.LocalDateTime

data class GetCommitsResponse(
    val committer: CommitterElement,
    val commit: CommitElement
)

data class CommitterElement(
    val login: String,
)

data class CommitElement(
    val author: AuthorElement
)

data class AuthorElement(
    val date: LocalDateTime
)
