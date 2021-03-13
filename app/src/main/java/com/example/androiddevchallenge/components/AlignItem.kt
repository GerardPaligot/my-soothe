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
package com.example.androiddevchallenge.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.FakeData
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun AlignItem(
    text: String,
    painter: Painter,
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    textStyle: TextStyle = MaterialTheme.typography.h3,
    contentColor: Color = MaterialTheme.colors.onSurface
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .semantics(true) {
                contentDescription = text
            }
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .height(88.dp)
                .aspectRatio(1f)
                .clip(shape),
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.height(24.dp - textStyle.fontSize.value.dp))
        Text(text = text, style = textStyle, color = contentColor)
    }
}

@Preview
@Composable
fun AlignItemPreview() {
    MyTheme {
        AlignItem(
            text = FakeData.bodies[0].text,
            painter = painterResource(id = FakeData.bodies[0].image)
        )
    }
}
