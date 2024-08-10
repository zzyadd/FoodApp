package com.example.foodapp.ui.fragments.info_out

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.foodapp.AuthActivity
import com.example.foodapp.R

class InfoFragment : Fragment() {

    private lateinit var viewModel: InfoFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_info, container, false)

        // Initialize ViewModel
        val application = requireNotNull(this.activity).application
        val viewModelFactory = InfoFragmentViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(InfoFragmentViewModel::class.java)

        val signOutButton: Button = view.findViewById(R.id.signoutbtn)
        signOutButton.setOnClickListener {
            viewModel.onSignOutClicked()
        }

        // Observe navigation to login
        viewModel.navigateToLogin.observe(viewLifecycleOwner, Observer { shouldNavigate ->
            if (shouldNavigate) {

                findNavController().navigate(R.id.action_infoFragment_to_navigation)
                viewModel.doneNavigating()
                val intent = Intent(requireContext(), AuthActivity::class.java)
                startActivity(intent)
            }
        })

        return view
    }
}
