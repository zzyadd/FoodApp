package com.example.foodapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView
import com.example.foodapp.R
import com.example.foodapp.ui.activites.MainActivity

class SplashFragment : Fragment(R.layout.fragment_splach) {

    private val splashDisplayLength: Long = 5000

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val animationView: LottieAnimationView = view.findViewById(R.id.splash_animation_view)
        animationView.playAnimation()

        Handler().postDelayed({
            val sharedPreferences = requireActivity().getSharedPreferences("loginPrefs", Context.MODE_PRIVATE)
            val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
            val intent = Intent(requireContext(), MainActivity::class.java)
            if (isLoggedIn) {

                startActivity(intent)
            } else {
                findNavController().navigate(R.id.action_splashFragment3_to_loginFragment)
            }
        }, splashDisplayLength)
    }
}
