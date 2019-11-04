package com.recyclerviewmvvm

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ImageLoader {



    companion object {
        @JvmStatic
        @BindingAdapter("android:src")
        fun setImage(imageView: ImageView, imageRes: String) {
            Glide.with(imageView.context)
                .setDefaultRequestOptions(
                    RequestOptions()
                        .circleCrop()
                )
                .load(imageRes)

                .into(imageView)
        }
    }
}