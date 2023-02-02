package com.hdt.onlinegroceries.ui.introduce.location

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hdt.onlinegroceries.base.ui.BaseFragment
import com.hdt.onlinegroceries.databinding.FragmentLocationBinding
import com.hdt.onlinegroceries.ui.MainActivity

class LocationFragment : BaseFragment<FragmentLocationBinding, MainActivity>() {

    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLocationBinding = FragmentLocationBinding.inflate(inflater)

    override fun setupView() {
        binding.apply {

        }
    }

    override fun setupData() {

    }


}