package juyeong.backend.global.error.exception

abstract class GitTrackException(
    val errorCode: ErrorCode,
) : RuntimeException() {
    val status: Int
        get() = errorCode.status
    override val message: String
        get() = errorCode.message
}