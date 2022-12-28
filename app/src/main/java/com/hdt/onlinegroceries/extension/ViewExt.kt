package com.hdt.onlinegroceries.extension

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.hdt.onlinegroceries.utils.SafeOnClickListener

fun View.hideKeyboard() {
    val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}

fun View.showKeyboard() {
    val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, 0)
}

inline val ViewGroup.inflater: LayoutInflater get() = LayoutInflater.from(context)

fun View.visible() {
    if (visibility != View.VISIBLE) visibility = View.VISIBLE
}

fun View.gone() {
    if (visibility != View.GONE) visibility = View.GONE
}

fun View.invisible() {
    if (visibility != View.INVISIBLE) visibility = View.INVISIBLE
}

fun View.visibleIf(condition: Boolean, gone: Boolean = true) =
    if (condition) {
        visible()
    } else {
        if (gone) gone() else invisible()
    }

fun Context.openWebUrl(url: String) {
    val i = Intent(Intent.ACTION_VIEW)
    i.data = Uri.parse(url)
    return try {
        startActivity(i)
    } catch (error: ActivityNotFoundException) {
    }
}

fun View.setVisiable(visiable: Boolean, invisiable: Int = View.GONE) {
    visibility = if (visiable) View.VISIBLE else invisiable
}

fun View.onClick(safe: Boolean = true, action: (View) -> Unit) = setOnClickListener(
    SafeOnClickListener(safe, action)
)

fun View.onLongClick(action: (View) -> Unit) = setOnLongClickListener {
    action(it)
    true
}

fun ImageView.loadImageFromUrl(url: String?) {
    Glide.with(context)
        .load(url)
        .into(this)
}

fun ImageView.loadImageFromDrawable(image : Int) {
    Glide.with(context)
        .load(image)
        .into(this)
}

fun getColor(context: Context, idColor: Int): Int {
    return ContextCompat.getColor(context, idColor)
}