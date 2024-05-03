package juyeong.backend.domain.github.presentation.dto

data class GetRepoLanguageResponse(
    val languages: List<RepoLanguageElement>
)