package com.ilya.sporttest.presentation.web

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebScreen(
    onBackPressedListener: () -> Unit
) {
    BackHandler() {
        onBackPressedListener()
    }

    val url = "http://vaintell.tilda.ws/#rec502498187"

    AndroidView(factory = {

        WebView(it).apply {

            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )

            webViewClient = WebViewClient()
            loadUrl(url)

            settings.javaScriptEnabled = true
        }
    }, update = {
        it.loadUrl(url)
    })


}