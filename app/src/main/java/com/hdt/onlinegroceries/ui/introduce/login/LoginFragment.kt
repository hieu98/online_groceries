package com.hdt.onlinegroceries.ui.introduce.login

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hdt.onlinegroceries.R
import com.hdt.onlinegroceries.base.ui.BaseFragment
import com.hdt.onlinegroceries.databinding.FragmentLoginBinding
import com.hdt.onlinegroceries.extension.onClick
import com.hdt.onlinegroceries.ui.MainActivity

class LoginFragment : BaseFragment<FragmentLoginBinding, MainActivity>() {

    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding = FragmentLoginBinding.inflate(inflater)

    override fun setupView() {
        binding.apply {
            btnPhone.onClick {
                navigateTo(R.id.action_loginFragment_to_loginPhoneFragment)
            }
        }
    }

    override fun setupData() {

    }


}