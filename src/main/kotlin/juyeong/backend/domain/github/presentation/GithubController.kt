package juyeong.backend.domain.github.presentation

import juyeong.backend.domain.github.presentation.dto.GithubUserInfoResponse
import juyeong.backend.domain.github.service.GithubService
import juyeong.backend.global.util.openfeign.client.dto.TokenResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/github")
@RestController
class GithubController(
    private val githubService: GithubService,
) {
    @GetMapping("/token/{code}")
    fun getAccessToken(@PathVariable("code") code: String): TokenResponse = githubService.getAccessToken(code)

    @GetMapping("/user")
    fun getUserInfo(@RequestHeader("Authorization") token: String): GithubUserInfoResponse = githubService.getUserInfo(token)
}