package juyeong.backend.global.util.openfeign.client

import juyeong.backend.global.util.openfeign.client.dto.TokenResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "GithubTokenFeign", url = "https://github.com")
interface GithubTokenFeign {
    @GetMapping("/login/oauth/access_token")
    fun getAccessToken(
        @RequestParam("client_id") clientId: String,
        @RequestParam("client_secret") clientSecret: String,
        @RequestParam("code") code: String
    ): TokenResponse
}