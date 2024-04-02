package juyeong.backend.global.util.openfeign.client.exception

import juyeong.backend.global.error.exception.ErrorCode.FEIGN_TOKEN_EXPIRED
import juyeong.backend.global.error.exception.GitTrackException

object FeignTokenExpiredException : GitTrackException(FEIGN_TOKEN_EXPIRED)
