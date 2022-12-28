package com.hdt.onlinegroceries.ui.introduce.splash

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.hdt.onlinegroceries.base.ui.BaseViewModel
import kotlinx.coroutines.delay

class SplashViewModel(
    override val app: Application,
) : BaseViewModel(app) {

    var isLogin= MutableLiveData<Boolean>()

    init {
        getUser()
    }

    private fun getUser(){
        jobCall = launchJob {
            delay(3000)
            isLogin.postValue(true)
        }
    }
}