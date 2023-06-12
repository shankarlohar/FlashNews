package com.shankarlohar.flashnews.activities

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.shankarlohar.flashnews.activities.BaseActivity
import com.shankarlohar.flashnews.states.HomeState
import com.shankarlohar.flashnews.ui.screen.HomeScreen
import com.shankarlohar.flashnews.viewmodels.HomeVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<HomeVM, HomeState>() {
    override val viewModel: HomeVM by viewModels()

    @Composable
    override fun Content() {
        HomeScreen(viewModel)
    }
}