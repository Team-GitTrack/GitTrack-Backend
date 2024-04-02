package juyeong.backend.global.util.openfeign.client.exception

import juyeong.backend.global.error.exception.ErrorCode.FEIGN_UNAUTHORIZED
import juyeong.backend.global.error.exception.GitTrackException

object FeignUnAuthorizedException : GitTrackException(FEIGN_UNAUTHORIZED)
