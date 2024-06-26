package juyeong.backend.domain.github.service

import juyeong.backend.domain.github.presentation.dto.GetIssueListResponse
import juyeong.backend.domain.github.presentation.dto.GetOrganizationListResponse
import juyeong.backend.domain.github.presentation.dto.GetOrganizationMemberListResponse
import juyeong.backend.domain.github.presentation.dto.GetOrganizationRepoListResponse
import juyeong.backend.domain.github.presentation.dto.GetRepoContributorsResponse
import juyeong.backend.domain.github.presentation.dto.GetRepoLanguageResponse
import juyeong.backend.domain.github.presentation.dto.GetUserInfoResponse
import juyeong.backend.global.util.openfeign.client.dto.GithubUserInfoResponse
import juyeong.backend.domain.github.presentation.dto.QueryCommitsResponse
import juyeong.backend.domain.github.presentation.dto.element.CommitCountElement
import juyeong.backend.domain.github.presentation.dto.element.GetOrganizationReposElement
import juyeong.backend.domain.github.presentation.dto.element.IssueElement
import juyeong.backend.domain.github.presentation.dto.element.OrganizationElement
import juyeong.backend.domain.github.presentation.dto.element.OrganizationMemberElement
import juyeong.backend.domain.github.presentation.dto.element.RepoLanguageElement
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

    fun getUserInfo(token: String): GetUserInfoResponse {
        val user = githubFeign.getUserInfo(token)
        return GetUserInfoResponse(
            user.login,
            user.email ?: "Public Email을 설정해주세요.",
            user.followers,
            user.avatarUrl
        )
    }

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
        val issues = githubFeign.getIssueList(token, filter, "all")
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
        })
    }

    fun getRepoContributors(token: String, organization: String, repository: String): GetRepoContributorsResponse =
        GetRepoContributorsResponse(githubFeign.getContributors(token, organization, repository))

    fun getRepoCommits(token: String, organization: String, repository: String): QueryCommitsResponse {
        val response = githubFeign.getCommits(token, organization, repository)
        val map = HashMap<String, HashMap<Int, Int>>()
        response.forEach {
            val login = it.commit.author.name
            val month = it.commit.author.date.monthValue
            map.getOrPut(login) { HashMap() }.merge(month, 1, Int::plus)
        }
        return QueryCommitsResponse(map.flatMap {
            it.value.map { (month, count) ->
                CommitCountElement(it.key, month = month, value = count)
            }
        })
    }
}
