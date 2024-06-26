package juyeong.backend.domain.github.presentation.dto

data class GetUserInfoResponse(
    val login: String,
    val email: String? = "",
    val followers: Int,
    val avatarUrl: String,
)
