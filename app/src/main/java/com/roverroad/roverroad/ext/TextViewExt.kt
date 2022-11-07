package com.roverroad.roverroad.ext

import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.UnderlineSpan
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter


@BindingAdapter("bind:underLineText")
fun TextView.setUnderLineText(value: String) {
	val content = SpannableString(value)
	content.setSpan(UnderlineSpan(), 0, content.length, 0)
	this.text = content
}

fun TextView.setHyperLinks(
	vararg links: Pair<String, View.OnClickListener>
) {
	val spannableString = SpannableString(this.text)
	var startIndexOfLink = -1
	for (link in links) {
		val clickableSpan = object : ClickableSpan() {
			override fun updateDrawState(textPaint: TextPaint) {
				textPaint.color = textPaint.linkColor
				textPaint.isUnderlineText = true
			}

			override fun onClick(view: View) {
				Selection.setSelection((view as TextView).text as Spannable, 0)
				view.invalidate()
				link.second.onClick(view)
			}
		}
		startIndexOfLink = this.text.toString().indexOf(link.first, startIndexOfLink + 1)
		if (startIndexOfLink == -1) continue
		spannableString.setSpan(
			clickableSpan, startIndexOfLink, startIndexOfLink + link.first.length,
			Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
		)
	}
	this.movementMethod = LinkMovementMethod.getInstance()
	this.setText(spannableString, TextView.BufferType.SPANNABLE)
}
