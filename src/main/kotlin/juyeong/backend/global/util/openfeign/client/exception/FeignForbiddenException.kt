package juyeong.backend.global.util.openfeign.client.exception

import juyeong.backend.global.error.exception.ErrorCode.FEIGN_FORBIDDEN
import juyeong.backend.global.error.exception.GitTrackException

object FeignForbiddenException : GitTrackException(FEIGN_FORBIDDEN)