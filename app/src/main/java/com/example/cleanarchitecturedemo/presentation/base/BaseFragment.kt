package com.example.cleanarchitecturedemo.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * Created by Ajeet Singh on 06/06/22.
 */

/**
 * Base Fragment that will provide binding by default
 */
abstract class BaseFragment<T : ViewDataBinding> : Fragment() {
    private var _binding: T? = null
    val binding: T
        get() = _binding!!

    abstract fun getLayoutId(): Int


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}