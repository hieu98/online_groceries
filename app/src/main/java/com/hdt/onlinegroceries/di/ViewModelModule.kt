package com.hdt.onlinegroceries.di

import com.hdt.onlinegroceries.ui.introduce.splash.SplashViewModel
import com.hdt.onlinegroceries.ui.shop.ShopViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ShopViewModel(get(), get()) }
    viewModel { SplashViewModel(get()) }
}