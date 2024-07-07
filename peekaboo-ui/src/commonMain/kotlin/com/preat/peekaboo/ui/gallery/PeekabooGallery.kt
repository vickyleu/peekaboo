/*
 * Copyright 2023-2024 onseok
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.preat.peekaboo.ui.gallery

import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.InternalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import coil3.compose.LocalPlatformContext

@ExperimentalPeekabooGalleryApi
@Composable
internal expect fun PeekabooGallery(
    modifier: Modifier = Modifier,
    state: GalleryPickerState = rememberGalleryPickerState(),
    lazyGridState: LazyGridState = rememberLazyGridState(),
    backgroundColor: Color = Color.Black,
    header: @Composable () -> Unit = {},
    progressIndicator: @Composable () -> Unit = {},
    permissionDeniedContent: @Composable () -> Unit = {},
    onImageSelected: (ByteArray?) -> Unit,
)

@OptIn(InternalComposeUiApi::class, ExperimentalPeekabooGalleryApi::class)
@Composable
fun PeekabooGalleryWrapper(
    modifier: Modifier = Modifier,
    state: GalleryPickerState = rememberGalleryPickerState(),
    lazyGridState: LazyGridState = rememberLazyGridState(),
    backgroundColor: Color = Color.Black,
    header: @Composable () -> Unit = {},
    progressIndicator: @Composable () -> Unit = {},
    permissionDeniedContent: @Composable () -> Unit = {},
    onImageSelected: (ByteArray?) -> Unit,
) {
    val context = LocalPlatformContext.current
    PeekabooGallery(
        modifier = modifier,
        state = state,
        lazyGridState = lazyGridState,
        backgroundColor = backgroundColor,
        header = header,
        progressIndicator = progressIndicator,
        permissionDeniedContent = permissionDeniedContent,
        onImageSelected = onImageSelected,
    )
}

