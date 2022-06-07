package com.example.cleanarchitecturedemo.presentation.meal_search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import com.example.cleanarchitecturedemo.R
import com.example.cleanarchitecturedemo.databinding.FragmentMealSearchBinding
import com.example.cleanarchitecturedemo.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Ajeet Singh on 06/06/22.
 */
@AndroidEntryPoint
class MealSearchFragment : BaseFragment<FragmentMealSearchBinding>() {

    override fun getLayoutId()=R.layout.fragment_meal_search
    private val searchAdapter = MealSearchAdapter()

    private val viewModel: MealSearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        binding.mealSearchRecycler.apply {
            adapter = searchAdapter
        }


        binding.mealSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String?): Boolean {
                s?.let {
                    viewModel.getSearchMeals(it)
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })

        lifecycle.coroutineScope.launchWhenCreated {
            viewModel.mealSearchState.collect { mealSearchState ->
                if (mealSearchState.isLoading) {
                    binding.nothingFound.visibility = View.GONE
                    binding.progressMealSearch.visibility = View.VISIBLE
                }
                if (mealSearchState.error.isNotBlank()) {
                    binding.nothingFound.visibility = View.GONE
                    binding.progressMealSearch.visibility = View.GONE
                    Toast.makeText(requireContext(), mealSearchState.error, Toast.LENGTH_SHORT).show()
                }

                mealSearchState.data?.let {
                    if (it.isEmpty()) {
                        binding.nothingFound.visibility = View.VISIBLE
                    }
                    binding.progressMealSearch.visibility = View.GONE
                    searchAdapter.setContentList(it.toMutableList())
                }


            }
        }


        searchAdapter.itemClickListener { meal->
            findNavController().navigate(
                MealSearchFragmentDirections.actionMealSearchFragmentToMealDetailsFragment(meal.mealId)
            )
        }


    }



}