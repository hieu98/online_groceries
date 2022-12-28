package com.hdt.onlinegroceries.ui.shop

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hdt.onlinegroceries.base.ui.BaseFragment
import com.hdt.onlinegroceries.databinding.FragmentShopBinding
import com.hdt.onlinegroceries.ui.MainActivity

class ShopFragment : BaseFragment<FragmentShopBinding, MainActivity>() {

    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentShopBinding = FragmentShopBinding.inflate(inflater)

    override fun setupView() {
        showBottomNav(true)
    }

    override fun setupData() {

    }


}