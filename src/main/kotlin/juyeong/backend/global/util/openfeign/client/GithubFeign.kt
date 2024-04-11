package juyeong.backend.global.util.openfeign.client

import juyeong.backend.domain.github.presentation.dto.GithubUserInfoResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(name = "GithubTokenFeign", url = "https://api.github.com")
interface GithubFeign {
    @GetMapping("/user")
    fun getUserInfo(@RequestHeader("Authorization") authorization: String): GithubUserInfoResponse
}