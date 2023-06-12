package com.shankarlohar.flashnews.states

import androidx.compose.runtime.Immutable
import com.shankarlohar.flashnews.models.Article

@Immutable
data class HomeState private constructor(
    val isLoading: Boolean = true,
    val newsCategories: List<NewsCategory> = emptyList(),
    val selectedCategory: NewsCategory? = null,
    val selectedCategoryIndex: Int = 0,
    val showNewCategoryTabs: Boolean = false,
    val news: List<Article> = emptyList(),
    val error: String? = null
) : BaseState {
    companion object {
        val initialState: HomeState
            get() = HomeState()
    }
}

@Immutable
data class NewsCategory(
    val displayName: String, val category: String
)