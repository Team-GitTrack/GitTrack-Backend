package juyeong.backend.domain.github.service

import juyeong.backend.domain.github.presentation.dto.GetIssueListResponse
import juyeong.backend.domain.github.presentation.dto.GetOrganizationListResponse
import juyeong.backend.domain.github.presentation.dto.GetOrganizationMemberListResponse
import juyeong.backend.domain.github.presentation.dto.GetOrganizationRepoListResponse
import juyeong.backend.domain.github.presentation.dto.GetOrganizationReposElement
import juyeong.backend.domain.github.presentation.dto.GetRepoLanguageResponse
import juyeong.backend.domain.github.presentation.dto.GithubUserInfoResponse
import juyeong.backend.domain.github.presentation.dto.IssueElement
import juyeong.backend.domain.github.presentation.dto.OrganizationElement
import juyeong.backend.domain.github.presentation.dto.OrganizationMemberElement
import juyeong.backend.domain.github.presentation.dto.RepoLanguageElement
import juyeong.backend.global.util.openfeign.client.GithubFeign
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
    private val githubFeign: GithubFeign,
) {
    fun getAccessToken(code: String): TokenResponse = githubTokenFeign.getAccessToken(clientId, clientSecret, code)

    fun getUserInfo(token: String): GithubUserInfoResponse = githubFeign.getUserInfo(token)

    fun getOrganizationList(token: String): GetOrganizationListResponse {
        val organizations = githubFeign.getUserOrganizationList(token)

        return GetOrganizationListResponse(
            organizations.map {
                OrganizationElement(
                    it.login,
                    it.avatarUrl,
                    it.description ?: ""
                )
            }
        )
    }

    fun getIssueList(token: String, filter: String): GetIssueListResponse {
        val issues = githubFeign.getIssueList(token, filter, "open")
        return GetIssueListResponse(
            issues.map {
                IssueElement(
                    it.repository.fullName, it.title, it.number
                )
            }
        )
    }

    fun getOrganizationMembers(token: String, organization: String): GetOrganizationMemberListResponse {
        val response = githubFeign.getOrganizationMembers(token, organization)
        return GetOrganizationMemberListResponse(
            response.map {
                OrganizationMemberElement(it.login, it.avatarUrl)
            }
        )
    }

    fun getOrganizationRepos(token: String, organization: String): GetOrganizationRepoListResponse {
        val response = githubFeign.getOrganizationRepos(token, organization)
        return GetOrganizationRepoListResponse(response.map {
            GetOrganizationReposElement(
                it.name,
                it.description ?: "",
                it.private
            )
        })
    }

    fun getRepoLanguages(organization: String, repository: String): GetRepoLanguageResponse {
        val response = githubFeign.getRepoLanguage(organization, repository)
        return GetRepoLanguageResponse(response.map {
            RepoLanguageElement(
                it.key,
                it.value
            )
        }
        )
    }
}