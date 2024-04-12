package juyeong.backend.domain.github.presentation.dto

data class GithubUserInfoResponse(
    val login: String = "",
    val email: String = "",
    val followers: Int = 0,
    val avatarUrl: String = "",
)
