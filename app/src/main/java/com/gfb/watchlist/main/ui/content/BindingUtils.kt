package com.gfb.watchlist.main.ui.content

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator


@BindingAdapter("releasedText")
fun TextView.setReleased(released: String) {
    text = released
}

@BindingAdapter("imageUrl")
fun ImageView.setImage(url: String) {

    val requestCreator: RequestCreator = picasso.load(url)
    requestCreator.fit().into(this)

}

private val picasso: Picasso
    get() = Picasso.get()
