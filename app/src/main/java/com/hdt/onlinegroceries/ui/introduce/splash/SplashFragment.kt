package com.hdt.onlinegroceries.ui.introduce.splash

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hdt.onlinegroceries.R
import com.hdt.onlinegroceries.base.ui.BaseFragment
import com.hdt.onlinegroceries.databinding.FragmentSplashBinding
import com.hdt.onlinegroceries.ui.MainActivity
import org.koin.android.ext.android.inject

class SplashFragment : BaseFragment<FragmentSplashBinding, MainActivity>() {

    private val splashViewModel : SplashViewModel by inject()

    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSplashBinding = FragmentSplashBinding.inflate(inflater)

    override fun setupView() {
        showBottomNav(false)

        splashViewModel.isLogin.observe(viewLifecycleOwner){
            if (it){
                navigateTo(R.id.action_splashFragment_to_loginFragment)
            }
        }
    }

    override fun setupData() {

    }
}