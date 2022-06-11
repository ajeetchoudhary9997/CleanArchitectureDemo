package com.example.cleanarchitecturedemo.presentation.meal_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.cleanarchitecturedemo.R
import com.example.cleanarchitecturedemo.databinding.FragmentDetailsSearchBinding
import com.example.cleanarchitecturedemo.databinding.FragmentMealSearchBinding
import com.example.cleanarchitecturedemo.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Ajeet Singh on 06/06/22.
 */
@AndroidEntryPoint
class MealDetailsFragment : BaseFragment<FragmentDetailsSearchBinding>() {
    override fun getLayoutId() = R.layout.fragment_details_search
    private val viewModel: MealDetailsViewModel by viewModels()

    private val args: MealDetailsFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        args.mealId?.let {
            viewModel.getMealDetails(it)
        }

        lifecycleScope.launchWhenCreated {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.mealDetails.collect { mealDetailsState ->
                    if (mealDetailsState.isLoading) {
                    }
                    if (mealDetailsState.error.isNotBlank()) {
                        Toast.makeText(requireContext(), mealDetailsState.error, Toast.LENGTH_SHORT)
                            .show()
                    }
                    mealDetailsState.data?.let {
                        binding.mealDetails = it
                    }
                }
            }

        }


        binding.detailsBackArrow.setOnClickListener {
            findNavController().popBackStack()
        }

    }

}