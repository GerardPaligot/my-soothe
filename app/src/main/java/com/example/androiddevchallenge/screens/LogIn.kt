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
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.components.SootheButtons
import com.example.androiddevchallenge.components.SootheTextFields
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.taupe100
import com.example.androiddevchallenge.ui.theme.taupe800

@Composable
fun LogIn(
    isDarkMode: Boolean = isSystemInDarkTheme(),
    logIn: () -> Unit
) {
    val h1Color = if (isDarkMode) taupe100 else taupe800
    val background = if (isDarkMode) R.drawable.dark_login else R.drawable.light_login
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = background),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "LOG IN",
                style = MaterialTheme.typography.h1,
                color = h1Color,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .paddingFromBaseline(top = 200.dp),
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(align = Alignment.Center)
                    .padding(16.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Spacer(modifier = Modifier.height(32.dp))
                    SootheTextFields.Email()
                    Spacer(modifier = Modifier.height(8.dp))
                    SootheTextFields.Password()
                    Spacer(modifier = Modifier.height(8.dp))
                    SootheButtons.Primary("Log in", onClick = logIn)
                    Text(
                        text = buildAnnotatedString {
                            append("Don't have an account? ")
                            withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                                append("Sign up")
                            }
                        },
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.paddingFromBaseline(32.dp)
                    )
                }
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun LogInPreview() {
    MyTheme {
        LogIn(
            logIn = {}
        )
    }
}

@Preview(widthDp = 360, heightDp = 640, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LogInPreviewDark() {
    MyTheme(true) {
        LogIn(
            isDarkMode = true,
            logIn = {}
        )
    }
}
