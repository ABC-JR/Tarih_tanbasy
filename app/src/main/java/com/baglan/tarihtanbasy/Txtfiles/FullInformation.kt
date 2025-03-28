package com.baglan.tarihtanbasy.screens

import android.content.Context
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily

import androidx.compose.ui.text.font.FontWeight


import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.baglan.tarihtanbasy.screens.Lessons
import com.baglan.tarihtanbasy.R


@Composable
fun FullInformation(context: Context, navController: NavController) {
    val newsItem = Lessons.level

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp, top = 90.dp, bottom = 170.dp)
    ) {
        AsyncImage(
            model = newsItem.url,
            contentDescription = "News Image",
            modifier = Modifier
                .size(150.dp, 100.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        )

        Text(
            text = newsItem.title,
            fontWeight = FontWeight.W800,
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
            , fontFamily = FontFamily(Font(R.font.forum))
        )

        Text(
            text = newsItem.desc,
            fontWeight = FontWeight.W500,
            fontSize = 25.sp,
            modifier = Modifier.padding(bottom = 16.dp)
            , fontFamily = FontFamily(Font(R.font.forum))
        )

        // WebView сразу после текста, занимает всю оставшуюся часть экрана
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f) // Занимает оставшуюся высоту
        ) {
            WebViewScreen(url =newsItem.pathpdf)
        }
    }
}

@Composable
fun WebViewScreen(url: String) {
    var isLoading by remember { mutableStateOf(true) }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        AndroidView(
            factory = { context ->
                WebView(context).apply {
                    settings.javaScriptEnabled = true
                    webViewClient = object : WebViewClient() {
                        override fun onPageFinished(view: WebView?, url: String?) {
                            isLoading = false
                        }
                    }
                    loadUrl(url)
                }
            },
            modifier = Modifier.fillMaxSize()
        )

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.size(50.dp), color = Color(0xFF004AAD))
        }
    }
}

