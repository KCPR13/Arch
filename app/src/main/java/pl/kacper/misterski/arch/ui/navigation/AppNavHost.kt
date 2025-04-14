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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import pl.kacper.misterski.arch.ui.start.start
import pl.kacper.misterski.common.ui.navigation.NavigationItem
import pl.kacper.misterski.feature.dog.ui.dogs
import pl.kacper.misterski.feature.news.ui.news

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
        start(
            modifier = modifier,
            onDogsSelected = {
                navController.navigate(NavigationItem.Dog.route)
            },
            onNewsSelected = {
                navController.navigate(NavigationItem.News.route)
            }
        )


        dogs(
            modifier = modifier,
            onBackClick = {
                navController.navigateUp()
            })

        news(
            modifier = modifier,
            onBackClick = {
                navController.navigateUp()
            })
    }
}
