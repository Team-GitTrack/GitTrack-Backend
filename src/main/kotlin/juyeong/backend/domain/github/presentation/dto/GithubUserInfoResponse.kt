package juyeong.backend.domain.github.presentation.dto

data class GithubUserInfoResponse (
    val login: String?,
    val followers: Int?,
    val following: Int?,
)