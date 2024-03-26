package juyeong.backend.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String,
) {
    INTERNAL_SERVER_ERROR(500, "Internal Server Error")
}