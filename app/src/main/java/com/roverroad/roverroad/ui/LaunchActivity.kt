package com.roverroad.roverroad.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.roverroad.roverroad.R
import com.roverroad.roverroad.databinding.ActivityLaunchBinding
import com.roverroad.roverroad.ext.launch

class LaunchActivity : AppCompatActivity() {

	lateinit var binding: ActivityLaunchBinding
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_launch)

		setNavigation()
	}

	private fun setNavigation() = binding.run {
		btnLogin.setOnClickListener { launch(LoginActivity::class.java) }
		btnRegister.setOnClickListener { launch(RegisterActivity::class.java) }
	}

}