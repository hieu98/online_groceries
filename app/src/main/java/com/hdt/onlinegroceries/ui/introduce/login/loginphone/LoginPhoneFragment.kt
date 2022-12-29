package com.hdt.onlinegroceries.ui.introduce.login.loginphone

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.hdt.onlinegroceries.R
import com.hdt.onlinegroceries.base.ui.BaseFragment
import com.hdt.onlinegroceries.databinding.FragmentLoginPhoneBinding
import com.hdt.onlinegroceries.extension.onClick
import com.hdt.onlinegroceries.ui.MainActivity
import timber.log.Timber

class LoginPhoneFragment : BaseFragment<FragmentLoginPhoneBinding, MainActivity>() {

    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginPhoneBinding = FragmentLoginPhoneBinding.inflate(inflater)

    override fun setupView() {
        binding.apply {
            btnBack.onClick { popBackStack() }

            btnNextEnterCode.onClick {
                Log.d("123456","+84" + phoneNumber.text.toString())
                navigateTo(
                    R.id.action_loginPhoneFragment_to_enterCodeFragment,
                    bundleOf( "phone" to "+84" + phoneNumber.text.toString()),
                    R.id.nav_shop,
                    false
                )
            }
        }
    }

    override fun setupData() {

    }


}