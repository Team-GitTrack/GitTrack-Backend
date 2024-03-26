package juyeong.backend.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String,
) {
    INCORRECT_PASSWORD(400, "Incorrect Password"),
    INCORRECT_USER(400, "Incorrect User"),
    NOT_ALLOW_SELF_APPLICATION(400, "Not Allow Self Application"),
    BAD_FILE_EXTENSION(400, "Bad File Extension"),
    IMPOSSIBLE_APPLICATION(400, "Impossible Application"),

    TOKEN_INVALID(401, "Token Invalid"),
    TOKEN_EXPIRED(401, "Token Expired"),

    USER_NOT_FOUND(404, "User Not Found"),
    FEED_NOT_FOUND(404, "Feed Not Found"),

    ALREADY_ACCOUNT_ID(409, "Already Account Id"),
    ALREADY_NICKNAME(409, "Already Nickname"),
    ALREADY_APPLY(409, "Already Apply"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error")
}