package juyeong.backend.global.util.openfeign.client.dto

data class GithubUserInfoResponse(
    val login: String,
    val email: String? = "",
    val followers: Int,
    val avatarUrl: String,
)
