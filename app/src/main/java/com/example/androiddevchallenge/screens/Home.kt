/*
 * Copyright 2021 The Android Open Source Project
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
package com.example.androiddevchallenge.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.components.AlignItem
import com.example.androiddevchallenge.components.Favorite
import com.example.androiddevchallenge.components.HomeTitle
import com.example.androiddevchallenge.components.SootheBottomNavigation
import com.example.androiddevchallenge.components.SootheFloatingActionButtons
import com.example.androiddevchallenge.components.SootheTextFields
import com.example.androiddevchallenge.data.FakeData
import com.example.androiddevchallenge.data.Item
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

@Composable
fun Home(
    favorites: List<Item>,
    bodies: List<Item>,
    minds: List<Item>,
    onHome: () -> Unit,
    onProfile: () -> Unit,
    onPlay: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            SootheBottomNavigation(
                onHome = onHome,
                onProfile = onProfile,
                modifier = Modifier.navigationBarsPadding()
            )
        },
        floatingActionButton = {
            SootheFloatingActionButtons.Play(onClick = onPlay)
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true
    ) {
        LazyColumn {
            item {
                Spacer(modifier = Modifier.height(56.dp))
                SootheTextFields.Search(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
            }
            item {
                HomeTitle(
                    text = "Favorite collections",
                    modifier = Modifier
                        .paddingFromBaseline(top = 40.dp)
                        .padding(start = 16.dp, end = 16.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                LazyRow(
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                    contentPadding = PaddingValues(start = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    content = {
                        favorites.chunked(2) { (fav1, fav2) ->
                            item {
                                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                    Favorite(
                                        text = fav1.text,
                                        painter = painterResource(id = fav1.image)
                                    )
                                    Favorite(
                                        text = fav2.text,
                                        painter = painterResource(id = fav2.image)
                                    )
                                }
                            }
                        }
                    }
                )
            }
            item {
                HomeTitle(
                    text = "Align your body",
                    modifier = Modifier
                        .paddingFromBaseline(top = 40.dp)
                        .padding(start = 16.dp, end = 16.dp)
                )
                LazyRow(
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                    contentPadding = PaddingValues(start = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    content = {
                        items(items = bodies) { body ->
                            AlignItem(text = body.text, painter = painterResource(id = body.image))
                        }
                    }
                )
            }
            item {
                HomeTitle(
                    text = "Align your mind",
                    modifier = Modifier
                        .paddingFromBaseline(top = 40.dp)
                        .padding(start = 16.dp, end = 16.dp)
                )
                LazyRow(
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                    contentPadding = PaddingValues(start = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    content = {
                        items(items = minds) { mind ->
                            AlignItem(text = mind.text, painter = painterResource(id = mind.image))
                        }
                    }
                )
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun HomePreview() {
    MyTheme {
        Home(
            favorites = FakeData.favorites,
            bodies = FakeData.bodies,
            minds = FakeData.minds,
            onHome = {},
            onProfile = {},
            onPlay = {}
        )
    }
}

@Preview(widthDp = 360, heightDp = 640, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomePreviewDark() {
    MyTheme(true) {
        Home(
            favorites = FakeData.favorites,
            bodies = FakeData.bodies,
            minds = FakeData.minds,
            onHome = {},
            onProfile = {},
            onPlay = {}
        )
    }
}
