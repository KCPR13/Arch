/*
 * Copyright 2024 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pl.kacper.misterski.arch.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import pl.kacper.misterski.arch.ui.start.StartScreen
import pl.kacper.misterski.arch.ui.start.StartViewModel
import pl.kacper.misterski.core.utils.extensions.animatedDestination
import pl.kacper.misterski.dog.ui.DogsScreen
import pl.kacper.misterski.dog.ui.DogsViewModel
import pl.kacper.misterski.news.ui.NewsScreen
import pl.kacper.misterski.news.ui.NewsViewModel

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavigationItem.Start.route,
    ) {
        animatedDestination(NavigationItem.Start.route) {
            val viewModel: StartViewModel = hiltViewModel()

            StartScreen(modifier = modifier,
                onDogsSelected = {
                    navController.navigate(NavigationItem.Dog.route)
                },
                onNewsSelected = {
                    navController.navigate(NavigationItem.News.route)
                },
                locationStatusUiModel = viewModel.locationStatus
            )
        }
        animatedDestination(NavigationItem.Dog.route) {
            val viewModel: DogsViewModel = hiltViewModel()
            val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

            DogsScreen (
                modifier = modifier,
                uiState = uiState,
                onBackClick = {
                    navController.navigateUp()
                },
            )
        }

        animatedDestination(NavigationItem.News.route) {
            val viewModel: NewsViewModel = hiltViewModel()
            val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

            NewsScreen(
                modifier = modifier,
                uiState = uiState,
                onBackClick = {
                    navController.navigateUp()
                },
                onRefresh = { viewModel.fetchData()}
            )
        }
    }
}
