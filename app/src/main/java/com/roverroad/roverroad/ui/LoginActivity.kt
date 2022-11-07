
package com.roverroad.roverroad.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.roverroad.roverroad.R
import com.roverroad.roverroad.databinding.ActivityLoginBinding
import com.roverroad.roverroad.ext.launch

class LoginActivity : AppCompatActivity() {

	lateinit var binding: ActivityLoginBinding
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

		setNavigation()
		setError()
	}

	private fun setNavigation() = binding.run {
		btnRegister.setOnClickListener { launch(RegisterActivity::class.java) }
	}

	private fun setError() = binding.run {
		btnLogin.setOnClickListener {
			Toast.makeText(this@LoginActivity, "HTTP 500 Internal Server Error", Toast.LENGTH_SHORT).show()
		}
	}
}