package juyeong.backend.global.util.openfeign.client.exception

import juyeong.backend.global.error.exception.ErrorCode.FEIGN_BAD_REQUEST
import juyeong.backend.global.error.exception.GitTrackException

object FeignBadRequestException : GitTrackException(FEIGN_BAD_REQUEST)