package juyeong.backend.global.util.openfeign.client.dto

data class GetIssuesResponse(
    val title: String,
    val number: Int,
    val repository: IssueRepositoryElement
)

data class IssueRepositoryElement(
    val fullName: String
)