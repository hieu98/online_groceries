package com.hdt.onlinegroceries.ui.introduce.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hdt.onlinegroceries.R
import com.hdt.onlinegroceries.base.ui.BaseFragment
import com.hdt.onlinegroceries.databinding.FragmentLoginBinding
import com.hdt.onlinegroceries.databinding.FragmentSplashBinding
import com.hdt.onlinegroceries.ui.MainActivity

class LoginFragment : BaseFragment<FragmentLoginBinding, MainActivity>() {

    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding = FragmentLoginBinding.inflate(inflater)

    override fun setupView() {

    }

    override fun setupData() {

    }


}