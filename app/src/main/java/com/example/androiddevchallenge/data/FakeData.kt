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
package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.R

data class Item(val text: String, val image: Int)

object FakeData {
    val favorites = arrayListOf(
        Item("Nature meditations", R.drawable.pexels_nothing_ahead_3571551),
        Item("Stress and anxiety", R.drawable.pexels_jim_1557238),
        Item("Self-massage", R.drawable.pexels_scott_webb_1029604),
        Item("Overwhelmed", R.drawable.pexels_ruvim_3560044),
    )

    val bodies = arrayListOf(
        Item("Inversions", R.drawable.pexels_chevanon_photography_317157),
        Item("Quick yoga", R.drawable.pexels_agung_pandit_wiguna_1812964),
        Item("Stretching", R.drawable.pexels_cliff_booth_4056723),
        Item("Tabata", R.drawable.pexels_elly_fairytale_4662438),
        Item("HIIT", R.drawable.pexels_the_lazy_artist_gallery_999309),
        Item("Pre-natal yoga", R.drawable.pexels_freestocksorg_396133)
    )

    val minds = arrayListOf(
        Item("Meditation", R.drawable.pexels_elly_fairytale_3822622),
        Item("With kids", R.drawable.pexels_valeria_ushakova_3094230),
        Item("Aromatherapy", R.drawable.pexels_elly_fairytale_3822622),
        Item("On the go", R.drawable.pexels_suraphat_nueaon_1241348),
        Item("With pets", R.drawable.pexels_cottonbro_4056535),
        Item("High stress", R.drawable.pexels_nathan_cowley_897817),
    )
}
