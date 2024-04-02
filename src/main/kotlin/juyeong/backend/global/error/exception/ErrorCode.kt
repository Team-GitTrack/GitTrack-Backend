package juyeong.backend.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String,
) {
    FEIGN_BAD_REQUEST(400, "Feign Bad Request"),

    FEIGN_UNAUTHORIZED(401, "Feign Unauthorized"),

    FEIGN_FORBIDDEN(403, "Feign Forbidden"),

    FEIGN_TOKEN_EXPIRED(419, "Feign Token Expired"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error")
}