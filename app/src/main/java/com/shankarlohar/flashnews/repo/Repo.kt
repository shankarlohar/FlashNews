package com.shankarlohar.flashnews.repo

import com.shankarlohar.flashnews.models.IpInfoResponse
import com.shankarlohar.flashnews.models.NewsResponse
import com.shankarlohar.flashnews.states.NewsCategory
import javax.inject.Inject

interface Repo {
    suspend fun getIpInfo(): IpInfoResponse
    suspend fun getTopHeadlines(countryCode: String, category: String): NewsResponse
    suspend fun getNews(query: String): NewsResponse
    suspend fun getNewsCategories(): List<NewsCategory>
}

class RepoImpl @Inject constructor(private val remoteDS: RemoteDS) : Repo {
    override suspend fun getIpInfo(): IpInfoResponse {
        return remoteDS.getIpInfo()
    }

    override suspend fun getTopHeadlines(countryCode: String, category: String): NewsResponse {
        return remoteDS.getTopHeadlines(countryCode, category)
    }

    override suspend fun getNews(query: String): NewsResponse {
        return remoteDS.getNews(query)
    }

    override suspend fun getNewsCategories(): List<NewsCategory> {
        return listOf(
            NewsCategory(displayName = "Business", category = "business"),
            NewsCategory(displayName = "Entertainment", category = "entertainment"),
            NewsCategory(displayName = "General", category = "general"),
            NewsCategory(displayName = "Health", category = "health"),
            NewsCategory(displayName = "Science", category = "science"),
            NewsCategory(displayName = "Sports", category = "sports"),
            NewsCategory(displayName = "Technology", category = "technology"),
        )
    }
}


