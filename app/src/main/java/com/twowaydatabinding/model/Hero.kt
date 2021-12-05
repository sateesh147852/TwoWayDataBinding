package com.twowaydatabinding.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

data class Hero(
    val name: String,
    val realname: String,
    val team: String,
    val firstappearance: String,
    val createdby: String,
    val publisher: String,
    val imageurl: String,
    val bio: String
) {

    companion object{

        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadImage(view: ImageView, url: String) {
            if(url!=null && url != ""){
                Glide.with(view)
                    .load(url)
                    .into(view)
            }

        }
    }



}
