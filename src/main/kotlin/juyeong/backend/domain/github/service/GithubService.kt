package juyeong.backend.domain.github.service

import juyeong.backend.global.util.openfeign.client.GithubTokenFeign
import juyeong.backend.global.util.openfeign.client.dto.TokenResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class GithubService(
    @Value("\${spring.security.oauth2.client.registration.github.client-id}")
    private val clientId: String,
    @Value("\${spring.security.oauth2.client.registration.github.client-secret}")
    private val clientSecret: String,
    private val githubTokenFeign: GithubTokenFeign,
) {
    fun getAccessToken(code: String): TokenResponse = githubTokenFeign.getAccessToken(clientId, clientSecret, code)
}