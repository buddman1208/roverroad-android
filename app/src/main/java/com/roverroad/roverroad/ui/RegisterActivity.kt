package com.roverroad.roverroad.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.roverroad.roverroad.R
import com.roverroad.roverroad.databinding.ActivityRegisterBinding
import com.roverroad.roverroad.ext.setHyperLinks

class RegisterActivity : AppCompatActivity() {

	lateinit var binding: ActivityRegisterBinding
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_register)

		setNavigation()
		setError()
	}

	private fun setNavigation() {
		binding.ivBack.setOnClickListener { finish() }
		binding.tvRegisterComment.setHyperLinks(
			Pair(getString(R.string.text_terms_of_service), View.OnClickListener {
				// TODO 여기에 이용약관 연결
			}),
			Pair(getString(R.string.text_privacy_policy), View.OnClickListener {
				// TODO 여기에 개인정보처리정책 연결
			})
		)
	}

	private fun setError() = binding.run {
		btnRegister.setOnClickListener {
			Toast.makeText(
				this@RegisterActivity,
				"HTTP 500 Internal Server Error",
				Toast.LENGTH_SHORT
			).show()
		}
	}
}