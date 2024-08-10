package com.example.foodapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodapp.R


class aboutFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("StaticFragment", "onViewCreated")
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("StaticFragment", "onActivityCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d("StaticFragment", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("StaticFragment", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("StaticFragment", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("StaticFragment", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("StaticFragment", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("StaticFragment", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("StaticFragment", "onDetach")
    }


}