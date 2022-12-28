package com.hdt.onlinegroceries.ui.account

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hdt.onlinegroceries.R
import com.hdt.onlinegroceries.base.ui.BaseFragment
import com.hdt.onlinegroceries.databinding.FragmentAccountBinding
import com.hdt.onlinegroceries.databinding.FragmentCartBinding
import com.hdt.onlinegroceries.ui.MainActivity

class AccountFragment : BaseFragment<FragmentAccountBinding, MainActivity>() {

    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAccountBinding = FragmentAccountBinding.inflate(inflater)

    override fun setupView() {

    }

    override fun setupData() {

    }


}