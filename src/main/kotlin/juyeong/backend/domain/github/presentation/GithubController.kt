package juyeong.backend.domain.github.presentation

import juyeong.backend.domain.github.presentation.dto.GetOrganizationListResponse
import juyeong.backend.domain.github.presentation.dto.GetOrganizationMemberListResponse
import juyeong.backend.domain.github.presentation.dto.GetOrganizationRepoListResponse
import juyeong.backend.domain.github.presentation.dto.GetRepoContributorsResponse
import juyeong.backend.domain.github.presentation.dto.GetRepoLanguageResponse
import juyeong.backend.domain.github.presentation.dto.GithubUserInfoResponse
import juyeong.backend.domain.github.presentation.dto.QueryCommitsResponse
import juyeong.backend.domain.github.service.GithubService
import juyeong.backend.global.util.openfeign.client.dto.TokenResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/github")
@RestController
class GithubController(
    private val githubService: GithubService,
) {
    @GetMapping("/token/{code}")
    fun getAccessToken(@PathVariable("code") code: String): TokenResponse = githubService.getAccessToken(code)

    @GetMapping("/user")
    fun getUserInfo(@RequestHeader("Authorization") token: String): GithubUserInfoResponse =
        githubService.getUserInfo(token)

    @GetMapping("/organizations")
    fun getOrganizationList(@RequestHeader("Authorization") token: String): GetOrganizationListResponse =
        githubService.getOrganizationList(token)

    @GetMapping("/issues")
    fun getIssuesList(@RequestHeader("Authorization") token: String, @RequestParam filter: String) =
        githubService.getIssueList(token, filter)

    @GetMapping("/{organization}/members")
    fun getOrganizationMembers(
        @RequestHeader("Authorization") token: String, @PathVariable organization: String
    ): GetOrganizationMemberListResponse = githubService.getOrganizationMembers(token, organization)

    @GetMapping("/{organization}/repos")
    fun getOrganizationRepos(
        @RequestHeader("Authorization") token: String, @PathVariable organization: String
    ): GetOrganizationRepoListResponse = githubService.getOrganizationRepos(token, organization)

    @GetMapping("/{organization}/{repository}/languages")
    fun getRepoLanguage(@PathVariable organization: String, @PathVariable repository: String): GetRepoLanguageResponse =
        githubService.getRepoLanguages(organization, repository)

    @GetMapping("/{organization}/{repository}/contributors")
    fun getRepoContributors(
        @RequestHeader("Authorization") token: String,
        @PathVariable organization: String,
        @PathVariable repository: String
    ): GetRepoContributorsResponse = githubService.getRepoContributors(token, organization, repository)

    @GetMapping("/{org}/{repo}/commits")
    fun getRepoCommit(
        @RequestHeader("Authorization") token: String,
        @PathVariable org: String,
        @PathVariable repo: String
    ): QueryCommitsResponse = githubService.getRepoCommits(token, org, repo)
}