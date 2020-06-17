package com.example.kotlinnews

import android.annotation.SuppressLint
import android.os.Build
import android.security.keystore.KeyNotYetValidException
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.WebView
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.GenericTransitionOptions.with
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.with
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions.with
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.with
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("srcCompat")
fun displayThumbNail(imgView: ImageView, imgUri: String?) {
    if (imgUri == null) {
        imgView.visibility = View.GONE
    } else {
        imgView.visibility = View.VISIBLE
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.default_placeholder_300x300)
                    .error(R.drawable.default_placeholder_300x300)
            )
            .into(imgView)
    }
}

@SuppressLint("SetJavaScriptEnabled")
@BindingAdapter("uri")
fun displayArticle(webView: WebView, articleUrl: String?) {
    val webSettings = webView.settings
    webSettings.javaScriptEnabled = true
    webSettings.useWideViewPort = true
    webSettings.builtInZoomControls=true
    webSettings.displayZoomControls=true
    webSettings.loadWithOverviewMode=true

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        webView.webViewClient = WebClient()
    }
    webView.loadUrl(articleUrl)
}