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

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import java.util.Locale

enum class IconSelected { HOME, PROFILE }

@Composable
fun SootheBottomNavigation(
    onHome: () -> Unit,
    onProfile: () -> Unit,
    modifier: Modifier = Modifier,
    selected: MutableState<IconSelected> = remember { mutableStateOf(IconSelected.HOME) },
    backgroundColor: Color = MaterialTheme.colors.background,
    elevation: Dp = 8.dp
) {
    BottomNavigation(
        modifier = modifier,
        backgroundColor = backgroundColor,
        elevation = elevation
    ) {
        SootheBottomNavigationItem(
            label = "Home",
            icon = Icons.Filled.Spa,
            selected = selected.value == IconSelected.HOME,
            onClick = {
                if (selected.value != IconSelected.HOME) {
                    selected.value = IconSelected.HOME
                }
                onHome()
            }
        )
        SootheBottomNavigationItem(
            label = "Profile",
            icon = Icons.Filled.AccountCircle,
            selected = selected.value == IconSelected.PROFILE,
            onClick = {
                if (selected.value != IconSelected.PROFILE) {
                    selected.value = IconSelected.PROFILE
                }
                onProfile()
            }
        )
    }
}

@Composable
internal fun RowScope.SootheBottomNavigationItem(
    label: String,
    icon: ImageVector,
    onClick: (selected: Boolean) -> Unit,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    labelStyle: TextStyle = MaterialTheme.typography.caption,
    contentColor: Color = MaterialTheme.colors.onBackground
) {
    val tint = if (selected) contentColor else contentColor.copy(alpha = .5f)
    BottomNavigationItem(
        selected = selected,
        modifier = modifier.semantics { contentDescription = label },
        onClick = {
            onClick(selected)
        },
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(18.dp),
                tint = tint
            )
        },
        label = {
            Text(
                text = label.toUpperCase(Locale.getDefault()),
                style = labelStyle,
                color = tint
            )
        },
    )
}

@Preview
@Composable
fun SootheBottomNavigationPreview() {
    MyTheme {
        SootheBottomNavigation(
            onHome = {},
            onProfile = {}
        )
    }
}
