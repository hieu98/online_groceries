package com.hdt.onlinegroceries.ui.favorite

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hdt.onlinegroceries.R
import com.hdt.onlinegroceries.base.ui.BaseFragment
import com.hdt.onlinegroceries.databinding.FragmentFavoriteBinding
import com.hdt.onlinegroceries.databinding.FragmentLoginBinding
import com.hdt.onlinegroceries.ui.MainActivity

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding, MainActivity>() {

    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavoriteBinding = FragmentFavoriteBinding.inflate(inflater)

    override fun setupView() {

    }

    override fun setupData() {

    }


}