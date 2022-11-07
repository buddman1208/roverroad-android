package com.roverroad.roverroad.ext

import android.app.Activity
import android.content.Intent
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.UnderlineSpan
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter

fun Activity.launch(cls: Class<*>) {
	startActivity(Intent(this, cls))
}