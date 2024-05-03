package juyeong.backend.global.util.openfeign.client

import juyeong.backend.domain.github.presentation.dto.GithubUserInfoResponse
import juyeong.backend.global.util.openfeign.client.dto.GetContributorResponse
import juyeong.backend.global.util.openfeign.client.dto.GetIssuesResponse
import juyeong.backend.global.util.openfeign.client.dto.GetOrganizationReposResponse
import juyeong.backend.global.util.openfeign.client.dto.GetUserOrganizationsResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "GithubTokenFeign", url = "https://api.github.com")
interface GithubFeign {
    @GetMapping("/user")
    fun getUserInfo(@RequestHeader("Authorization") authorization: String): GithubUserInfoResponse

    @GetMapping("/user/orgs")
    fun getUserOrganizationList(@RequestHeader("Authorization") authorization: String): List<GetUserOrganizationsResponse>

    @GetMapping("/issues")
    fun getIssueList(
        @RequestHeader("Authorization") authorization: String,
        @RequestParam("filter") filter: String,
        @RequestParam("state") state: String
    ): List<GetIssuesResponse>

    @GetMapping("/orgs/{org}/members")
    fun getOrganizationMembers(@RequestHeader("Authorization") authorization: String, @PathVariable org: String): List<GithubUserInfoResponse>

    @GetMapping("/orgs/{org}/repos")
    fun getOrganizationRepos(@RequestHeader("Authorization") authorization: String, @PathVariable org: String): List<GetOrganizationReposResponse>

    @GetMapping("/repos/{org}/{repo}/languages")
    fun getRepoLanguage(@PathVariable org: String, @PathVariable repo: String): Map<String, Int>

    @GetMapping("/repos/{org}/{repo}/contributors")
    fun getContributors(@RequestHeader("Authorization") authorization: String, @PathVariable org: String, @PathVariable repo: String): List<GetContributorResponse>
}