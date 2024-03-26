package juyeong.backend.global.exception

import juyeong.backend.global.error.exception.ErrorCode.INTERNAL_SERVER_ERROR
import juyeong.backend.global.error.exception.GitTrackException

object InternalServerError : GitTrackException(INTERNAL_SERVER_ERROR)