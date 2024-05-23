package juyeong.backend.global.util.openfeign

import feign.FeignException
import feign.Response
import feign.codec.ErrorDecoder
import juyeong.backend.global.exception.InternalServerError
import juyeong.backend.global.util.openfeign.client.exception.FeignBadRequestException
import juyeong.backend.global.util.openfeign.client.exception.FeignForbiddenException
import juyeong.backend.global.util.openfeign.client.exception.FeignTokenExpiredException
import juyeong.backend.global.util.openfeign.client.exception.FeignUnAuthorizedException

class FeignClientErrorDecoder : ErrorDecoder {
    override fun decode(methodKey: String, response: Response): Exception {
        if (response.status() >= 400) {
            when (response.status()) {
                400 -> throw FeignBadRequestException
                401 -> throw FeignUnAuthorizedException
                403 -> throw FeignForbiddenException
                419 -> throw FeignTokenExpiredException
                else -> throw InternalServerError
            }
        }

        return FeignException.errorStatus(methodKey, response)
    }
}