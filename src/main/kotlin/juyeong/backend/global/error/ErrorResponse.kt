package juyeong.backend.global.error

import juyeong.backend.global.error.exception.GitTrackException


class ErrorResponse(
    val status: Int,
    val message: String,
) {
    companion object {
        fun of(e: GitTrackException): ErrorResponse {
            return ErrorResponse(e.status, e.message)
        }
    }
}