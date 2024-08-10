package com.example.foodapp.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.foodapp.data.pojo.MealDetail
import com.example.foodapp.databinding.FragmentSearchBinding
import com.example.foodapp.mvvm.SearchMVVM
import com.example.foodapp.ui.activites.MealDetailesActivity
import com.example.foodapp.ui.fragments.HomeFragment.Companion.MEAL_ID
import com.example.foodapp.ui.fragments.HomeFragment.Companion.MEAL_STR
import com.example.foodapp.ui.fragments.HomeFragment.Companion.MEAL_THUMB

class SearchFragment : Fragment() {
    //private lateinit var myAdapter: _root_ide_package_.com.example.easyfood.adapters.MealRecyclerAdapter
    private lateinit var binding: FragmentSearchBinding
    private lateinit var searchMvvm: SearchMVVM
    private var mealId = ""
    private var mealStr = ""
    private var mealThub = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //myAdapter = _root_ide_package_.com.example.resturentproject.adapters.MealRecyclerAdapter()
        searchMvvm = ViewModelProviders.of(this)[SearchMVVM::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onSearchClick()
        observeSearchLiveData()
        setOnMealCardClick()
    }

    private fun setOnMealCardClick() {
        binding.searchedMealCard.setOnClickListener {
            val intent = Intent(context, MealDetailesActivity::class.java)

            intent.putExtra(MEAL_ID, mealId)
            intent.putExtra(MEAL_STR, mealStr)
            intent.putExtra(MEAL_THUMB, mealThub)

            startActivity(intent)


        }
    }

    private fun onSearchClick() {
        binding.icSearch.setOnClickListener {
            searchMvvm.searchMealDetail(binding.edSearch.text.toString(),context)

        }
    }

    private fun observeSearchLiveData() {
        searchMvvm.observeSearchLiveData()
            .observe(viewLifecycleOwner, object : Observer<MealDetail> {
                override fun onChanged(value: MealDetail) {
                    if (value == null) {
                        Toast.makeText(context, "No such a meal", Toast.LENGTH_SHORT).show()
                    } else {
                        binding.apply {

                            mealId = value.idMeal
                            mealStr = value.strMeal
                            mealThub = value.strMealThumb

                            Glide.with(context!!.applicationContext)
                                .load(value.strMealThumb)
                                .into(imgSearchedMeal)

                            tvSearchedMeal.text = value.strMeal
                            searchedMealCard.visibility = View.VISIBLE
                        }
                    }
                }
            })
    }


}