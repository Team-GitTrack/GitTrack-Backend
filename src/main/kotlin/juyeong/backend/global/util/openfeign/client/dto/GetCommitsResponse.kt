package juyeong.backend.global.util.openfeign.client.dto

import java.time.LocalDateTime

data class GetCommitsResponse(
    val commit: CommitElement
)

data class CommitElement(
    val author: AuthorElement
)

data class AuthorElement(
    val name: String,
    val date: LocalDateTime
)
