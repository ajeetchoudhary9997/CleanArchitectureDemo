package com.example.cleanarchitecturedemo.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.cleanarchitecturedemo.R

/**
 * Created by Ajeet Singh on 06/06/22.
 */

@BindingAdapter("loadImage")
fun urlToImage(view: ImageView, s: String?) {
    val options = RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error)
    Glide.with(view).setDefaultRequestOptions(options).load(s ?: "").into(view)
}