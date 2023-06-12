package com.shankarlohar.flashnews.di

import com.shankarlohar.flashnews.repo.RemoteDS
import com.shankarlohar.flashnews.repo.RemoteDSImpl
import com.shankarlohar.flashnews.repo.Repo
import com.shankarlohar.flashnews.repo.RepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {
    @Binds
    abstract fun bindRemoteDS(remoteDsImpl: RemoteDSImpl): RemoteDS

    @Binds
    abstract fun bindRepo(repoImpl: RepoImpl): Repo
}