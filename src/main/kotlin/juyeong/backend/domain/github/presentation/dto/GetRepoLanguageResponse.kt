package juyeong.backend.domain.github.presentation.dto

import juyeong.backend.domain.github.presentation.dto.element.RepoLanguageElement

data class GetRepoLanguageResponse(
    val languages: List<RepoLanguageElement>
)